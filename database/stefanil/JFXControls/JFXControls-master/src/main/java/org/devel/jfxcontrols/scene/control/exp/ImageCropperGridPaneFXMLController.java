/**
 * 
 */
package org.devel.jfxcontrols.scene.control.exp;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.binding.ObjectBinding;
import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.WorkerStateEvent;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Rectangle2D;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;

import org.devel.jfxcontrols.concurrent.ImageWriter;
import org.devel.jfxcontrols.concurrent.ImageLoader;
import org.devel.jfxcontrols.scene.control.ImageCropperScrollPane;
import org.devel.jfxcontrols.scene.image.SourceImageView;
import org.devel.jfxcontrols.scene.shape.CropperRectangle;

/**
 * 
 * 
 * @author stefan.illgen
 * 
 */
public class ImageCropperGridPaneFXMLController implements Initializable {

	private static final String TXT_choose_source_label = "Quelle";
	private static final String TXT_choose_target_label = "Ziel";

	public ImageCropperGridPaneFXMLController() {

	}

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		sourceImageView.setCropperRectangle(cropperRectangle);
		sourceImageView.initialize();
		cropperRectangle.initialize();
		bind();
	}

	// ############ Controller APIs ##############

	@FXML
	private GridPane imageCropperView;

	// the image cropper pane used for loading FXML
	// private ImageCropperGridPane imageCropperPane;

	@FXML
	private StackPane test;

	@FXML
	private ImageCropperScrollPane imageCropperScrollPane;

	@FXML
	private SourceImageView sourceImageView;

	@FXML
	private CropperRectangle cropperRectangle;

	@FXML
	private ImageView targetImageView;

	@FXML
	private Button saveImageButton;

	@FXML
	void loadImage(final ActionEvent event) {

		reset();

		// choose the name
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle(TXT_choose_source_label);
		fileChooser.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("All", "*.jpg", "*.jpeg",
						"*.png"),
				new FileChooser.ExtensionFilter("png", "*.png"),
				new FileChooser.ExtensionFilter("jpg", "*.jpg", "*.jpeg"));

		File imageFile = fileChooser.showOpenDialog(imageCropperView.getScene()
				.getWindow());

		// load source image
		loadSourceImage(imageFile);
	}

	/**
	 * 
	 * @param image
	 */
	public void loadSourceImage(File image) {
		if (image != null) {
			ImageLoader task = new ImageLoader(image);

			task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
				@Override
				public void handle(WorkerStateEvent event) {
					// if load image was successful
					if (task.getValue()) {
						sourceImageView.setImage(task.getImage());
					}
				}
			});
			new Thread(task).start();
		}
	}

	/**
	 * Saves the cropped image under the filename in the imageNameTextField.
	 * 
	 * @param event
	 *            is unused in this method
	 */
	@FXML
	void saveImage(final ActionEvent event) {

		// open file chooser dialog
		FileChooser fileChooser = new FileChooser();
		fileChooser.setTitle(TXT_choose_target_label);
		fileChooser.getExtensionFilters().addAll(
				new FileChooser.ExtensionFilter("All", "*.jpg", "*.jpeg",
						"*.png"),
				new FileChooser.ExtensionFilter("png", "*.png"),
				new FileChooser.ExtensionFilter("jpg", "*.jpg", "*.jpeg"));
		File imageFile = fileChooser.showSaveDialog(imageCropperView.getScene()
				.getWindow());

		saveImage(imageFile);
	}

	/**
	 * 
	 * @param image
	 */
	public void saveImage(File image) {
		Thread cropSaveThread = new Thread(new ImageWriter(image,
				getTargetImage(), cropperRectangle.getX(),
				cropperRectangle.getY(), cropperRectangle.getWidth(),
				cropperRectangle.getHeight()));

		if (image != null)
			cropSaveThread.start();
	}

	private void bind() {

		// bind image properties
		targetImageProperty().bind(sourceImageView.imageProperty());

		// bind view port of target image view
		targetImageView.viewportProperty().bind(
				new ObjectBinding<Rectangle2D>() {
					{
						super.bind(cropperRectangle.widthProperty(),
								cropperRectangle.translateXProperty(),
								cropperRectangle.translateYProperty());
					}

					@Override
					protected Rectangle2D computeValue() {

						double minX = cropperRectangle.translateXProperty()
								.add(cropperRectangle.layoutXProperty()).get();
						double minY = cropperRectangle.translateYProperty()
								.add(cropperRectangle.layoutYProperty()).get();
						double width = cropperRectangle.getWidth();
						double height = cropperRectangle.getHeight();

						return new Rectangle2D(minX, minY, width, height);

					}
				});

		// bind image cropper scroll pane width'n'height
		sourceImageView.imageProperty().addListener(
				new ChangeListener<Image>() {

					@Override
					public void changed(
							ObservableValue<? extends Image> observable,
							Image oldValue, Image newValue) {

						if (observable == null)
							sourceImageView.imageProperty()
									.removeListener(this);

						if (newValue != null) {
							// width
							imageCropperScrollPane
									.maxWidthObservablesProperty().clear();
							imageCropperScrollPane
									.maxWidthObservablesProperty().add(
											cropperRectangle.widthProperty());
							imageCropperScrollPane
									.maxWidthObservablesProperty().add(
											sourceImageView.fitWidthProperty());
							// height
							imageCropperScrollPane
									.maxHeightObservablesProperty().clear();
							imageCropperScrollPane
									.maxHeightObservablesProperty().add(
											cropperRectangle.heightProperty());
							imageCropperScrollPane
									.maxHeightObservablesProperty()
									.add(sourceImageView.fitHeightProperty());
						}

					}
				});

	}

	public ObjectProperty<Image> sourceImageProperty() {
		return sourceImageView.imageProperty();
	}

	public Image getSourcemage() {
		return sourceImageView.imageProperty().get();
	}

	public void setSourceImage(Image sourceImage) {
		sourceImageView.imageProperty().set(sourceImage);
	}

	public ObjectProperty<Image> targetImageProperty() {
		return targetImageView.imageProperty();
	}

	public Image getTargetImage() {
		return targetImageView.imageProperty().get();
	}

	public void setTargetImage(Image targetImage) {
		targetImageView.imageProperty().set(targetImage);
	}

	// ### Skinning ###

	// private void setupSkin() {
	// getStyleClass().add("image-cropper-grid");
	// }
	//
	// /**
	// * Integrate skin.
	// */
	// @Override
	// protected String getUserAgentStylesheet() {
	// return getClass().getResource("image-cropper.css").toExternalForm();
	// }

	private void reset() {
		sourceImageView.reset();
		cropperRectangle.reset();
	}

}
