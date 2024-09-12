package org.devel.jfxcontrols.sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Accordion;
import javafx.scene.control.TextArea;
import javafx.scene.control.TitledPane;
import javafx.scene.control.TreeCell;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.control.cell.TextFieldTreeCell;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import org.devel.jfxcontrols.resource.ImageRegistry;
import org.devel.jfxcontrols.resource.Images;
import org.devel.jfxcontrols.scene.control.Aggregator;
import org.devel.jfxcontrols.scene.control.CircleCheckBox;
import org.devel.jfxcontrols.scene.control.CircleCheckBoxSkin;
import org.devel.jfxcontrols.scene.control.FileSelectionDropArea;
import org.devel.jfxcontrols.scene.control.FilterableTableView;
import org.devel.jfxcontrols.scene.control.ImageCropper;
import org.devel.jfxcontrols.scene.control.ReflectableTreeItem;
import org.devel.jfxcontrols.scene.control.RotatableCheckBox;
import org.devel.jfxcontrols.scene.control.skin.RotatableCheckBoxSkin;
import org.devel.jfxcontrols.scene.control.svg.SvgIconButton;
import org.devel.jfxcontrols.scene.control.svg.SvgIconRadioButton;
import org.devel.jfxcontrols.scene.control.svg.SvgIconToggleButton;
import org.devel.jfxcontrols.scene.layout.Router;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;

/**
 * @author stefan.illgen
 */
public class JFXShowCase extends AnchorPane implements Initializable {

  @FXML
  private ImageView logoImageView;

  @FXML
  private Text logoText;

  @FXML
  private Accordion detailsAccordeon;

  @FXML
  private TitledPane exampleTitledPane;

  @FXML
  private TreeView<String> masterTreeView;

  @FXML
  private TitledPane scTitledPane;

  @FXML
  private AnchorPane exampleContainer;

  @FXML
  private TextArea scTextArea;

  public JFXShowCase() {
    loadFXML();
  }

  @Override
  @SuppressWarnings("unchecked")
  public void initialize(final URL location, final ResourceBundle resources) {
    masterTreeView.setCellFactory(treeView -> {
      final TreeCell<String> treeCell = new TextFieldTreeCell<>();
      treeCell.setOnMouseClicked(event -> {
        try {
          final ReflectableTreeItem<? extends Node> item =
              (ReflectableTreeItem<? extends Node>) ((TreeCell<String>) event.getSource()).getTreeItem();

          if (Objects.equals(item.getGroundClass(), CircleCheckBox.class)) {
            final CircleCheckBox ccb = new CircleCheckBox();
            ccb.setSkin(new CircleCheckBoxSkin(ccb));
            loadDetails(ccb);
          } else if (Objects.equals(item.getGroundClass(), RotatableCheckBox.class)) {
            final RotatableCheckBox rcb = new RotatableCheckBox();
            rcb.setSkin(new RotatableCheckBoxSkin(rcb));
            loadDetails(rcb);
          } else if (Objects.equals(item.getGroundClass(), FilterableTableView.class)) {
            final URL url = getClass().getResource("/org/devel/jfxcontrols/sample/FilterableTableViewExample.fxml");
            final Node filteredTableViewExample = FXMLLoader.load(url);
            loadDetails(filteredTableViewExample);
          } else if (Objects.equals(item.getGroundClass(), SvgIconButton.class)) {
            final URL url = getClass().getResource("/org/devel/jfxcontrols/sample/SvgIconButtonExample.fxml");
            final Node example = FXMLLoader.load(url);
            loadDetails(example);
          } else if (Objects.equals(item.getGroundClass(), SvgIconRadioButton.class)) {
            final URL url = getClass().getResource("/org/devel/jfxcontrols/sample/SvgIconRadioButtonExample.fxml");
            final Node example = FXMLLoader.load(url);
            loadDetails(example);
          } else if (Objects.equals(item.getGroundClass(), SvgIconToggleButton.class)) {
            final URL url = getClass().getResource("/org/devel/jfxcontrols/sample/SvgIconToggleButtonExample.fxml");
            final Node example = FXMLLoader.load(url);
            loadDetails(example);
          } else if (Objects.equals(item.getGroundClass(), FileSelectionDropArea.class)) {
            final URL url = getClass().getResource("/org/devel/jfxcontrols/sample/FileSelectionDropAreaExample.fxml");
            final Node fileSelectionDropAreaExample = FXMLLoader.load(url);
            loadDetails(fileSelectionDropAreaExample);
          } else {
            loadDetails(item.createGround());
          }
        } catch (InstantiationException | IllegalAccessException | ClassCastException | IOException e) {
          e.printStackTrace();
        }
      });

      return treeCell;
    });

    final TreeItem<String> root = new TreeItem<>("All Controls", ImageRegistry.getImageView(Images.LOGO_16));
    root.setExpanded(true);
    masterTreeView.setRoot(root);
    root.getChildren().addAll(getAllControls());
  }

  private List<TreeItem<String>> getAllControls() {
    return Arrays.asList(createTreeItem(Router.class),
        createTreeItem(ImageCropper.class),
        createTreeItem(Aggregator.class),
        createTreeItem(CircleCheckBox.class),
        createTreeItem(RotatableCheckBox.class),
        createTreeItem(FilterableTableView.class),
        createTreeItem(FileSelectionDropArea.class),
        createTreeItem(SvgIconRadioButton.class),
        createTreeItem(SvgIconButton.class),
        createTreeItem(SvgIconToggleButton.class));
  }

  private <T extends Node> TreeItem<String> createTreeItem(final Class<T> clazz) {
    return new ReflectableTreeItem<T>(clazz.getSimpleName(), ImageRegistry.getImageView(Images.LOGO_16), clazz);
  }

  private void loadFXML() {
    final URL url = getClass().getResource(getClass().getSimpleName() + ".fxml");
    final FXMLLoader fxmlLoader = new FXMLLoader(url);

    fxmlLoader.setRoot(this);
    fxmlLoader.setController(this);

    try {
      fxmlLoader.load();
    } catch (final IOException exception) {
      throw new RuntimeException(exception);
    }
  }

  private void loadDetails(final Node node) {
    exampleContainer.getChildren().clear();
    exampleContainer.getChildren().add(node);
    AnchorPane.clearConstraints(node);
    AnchorPane.setTopAnchor(node, 0.0);
    AnchorPane.setRightAnchor(node, 0.0);
    AnchorPane.setLeftAnchor(node, 0.0);
    AnchorPane.setBottomAnchor(node, 0.0);
    exampleTitledPane.setExpanded(true);
  }
}
