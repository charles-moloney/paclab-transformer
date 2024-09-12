/**
 * 
 */
package org.devel.jfxcontrols.scene.control.treetableview.skin;

import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeTableRow;

import org.devel.jfxcontrols.scene.control.treetableview.command.Adjustable;
import org.devel.jfxcontrols.scene.control.treetableview.command.Expand;
import org.devel.jfxcontrols.scene.control.treetableview.command.Expandable;
import org.devel.jfxcontrols.scene.control.treetableview.command.MouseKeyboardEventMapper;
import org.devel.jfxcontrols.scene.control.treetableview.command.MouseKeyboardEventMapper.ExpandEventMapper;
import org.devel.jfxcontrols.scene.control.treetableview.command.MouseKeyboardEventMapper.RowAdjustEventMapper;
import org.devel.jfxcontrols.scene.control.treetableview.command.RowAdjust;

import com.sun.javafx.scene.control.skin.VirtualFlow;

/**
 * @author stefan.illgen
 *
 */
public class TreeTableViewSkin<T>
	extends
		com.sun.javafx.scene.control.skin.TreeTableViewSkin<T> implements Expandable<T> {

	private static final String ROW_ADJUST = "ROW_ADJUST";
	private static final String INPUT_MODE = "INPUT_MODE";
	private static final String EXPAND = "EXPAND";

	private AdjustableFlow<T, TreeTableRow<T>> adjustableFlow;
	private RowAdjustEventMapper<T, TreeTableRow<T>> rowAdjustEventMapper;
	private ExpandEventMapper<T, TreeTableRow<T>> expandEventMapper;
	private TreeItem<T> selected;
	private int cellCountBeforeExpand;

	public TreeTableViewSkin(final org.devel.jfxcontrols.scene.control.treetableview.TreeTableView<T, Adjustable<T, TreeTableRow<T>>> treeTableView) {
		super(treeTableView);
		registerChangeListener(treeTableView.rowAdjustProperty(), ROW_ADJUST);
		registerChangeListener(treeTableView.inputModeProperty(), INPUT_MODE);
		registerChangeListener(treeTableView.inputModeProperty(), EXPAND);
		initRowAdjust();
		initExpand();
	}

	@Override
	protected void handleControlPropertyChanged(String p) {
		super.handleControlPropertyChanged(p);

		if (ROW_ADJUST.equals(p)) {
			initRowAdjust();
		} else if (INPUT_MODE.equals(p)) {
			reloadEventMapping();
		} else if (EXPAND.equals(p)) {
			initExpand();
		}
	}

	private void reloadEventMapping() {
		reloadAdjustMapping();
		reloadExpandMapping();
	}

	// ### row adjust ###

	private void initRowAdjust() {
		RowAdjust<T, TreeTableRow<T>> rowAdjust = getSkinnableC().getRowAdjust();
		if (rowAdjust != null) {
			rowAdjust.setReceiver(adjustableFlow);
		}
		reloadAdjustMapping();
	}

	private void reloadAdjustMapping() {
		if (rowAdjustEventMapper != null) {
			rowAdjustEventMapper.unregisterAll();
		}

		if (getSkinnableC().getInputMode() != null
			&& getSkinnableC().getRowAdjust() != null) {

			switch (getSkinnableC().getInputMode()) {
			case MOUSE_KEYBOARD:
				rowAdjustEventMapper = MouseKeyboardEventMapper.RowAdjustEventMapper.<T, TreeTableRow<T>> create(getSkinnableC(),
																												 getSkinnableC().getRowAdjust());
				break;
			case TOUCH:
				// rowAdjustEventMapper =
				// TouchKeyboardEventMapper.RowAdjustEventMapper.<T,
				// TreeTableRow<T>> create(getSkinnableC(),
				// rowAdjust);
				break;
			default:
				break;
			}
		}
	}

	// ### Expand ###

	private void initExpand() {
		Expand<T, TreeTableRow<T>> expand = getSkinnableC().getExpand();
		if (expand != null) {
			expand.setReceiver(this);
		}
		reloadExpandMapping();

		// getSkinnable().expandedItemCountProperty()
		// .addListener(new ChangeListener<Number>() {
		// @Override
		// public void changed(ObservableValue<? extends Number> obs,
		// Number oldV,
		// Number newV) {
		// if (newV != null && oldV != null) {
		// System.out.println(getNewPosition());
		// System.out.println(getCurrentPosition());
		// adjustableFlow.adjustPixels(getCurrentPosition()
		// - getNewPosition());
		// }
		//
		// }
		//
		// private double getNewPosition() {
		// return getSelectionModel().getSelectedIndex()
		// * adjustableFlow.getFixedCellLength();
		// }
		//
		// private double getCurrentPosition() {
		// return adjustableFlow.getPosition()
		// * getSkinnable().getFixedCellSize()
		// * getSkinnable().getExpandedItemCount();
		// }
		// });
	}

	private double getNewPosition() {
		return getSelectionModel().getSelectedIndex()
			* adjustableFlow.getFixedCellLength();
	}

	private double getCurrentPosition() {
		return adjustableFlow.getPosition() * getSkinnable().getFixedCellSize()
			* getSkinnable().getExpandedItemCount();
	}

	private void reloadExpandMapping() {
		if (expandEventMapper != null) {
			expandEventMapper.unregisterAll();
		}

		if (getSkinnableC().getInputMode() != null && getSkinnableC().getExpand() != null) {

			switch (getSkinnableC().getInputMode()) {
			case MOUSE_KEYBOARD:
				expandEventMapper = MouseKeyboardEventMapper.ExpandEventMapper.<T, TreeTableRow<T>> create(getSkinnableC(),
																										   getSkinnableC().getExpand());
				break;
			case TOUCH:
				// expandEventMapper =
				// TouchKeyboardEventMapper.expandEventMapper.<T,
				// TreeTableRow<T>> create(getSkinnableC(),
				// expand);
				break;
			default:
				break;
			}
		}
	}

	@Override
	public int expand() {

		cellCountBeforeExpand = adjustableFlow.getCellCount();

		final TreeItem<T> currentSelected = getSelectionModel().getSelectedItem();
		int result = getSelectionModel().getSelectedIndex();
		// getSelectionModel().clearSelection();

		if (!currentSelected.isLeaf()) {
			currentSelected.setExpanded(!currentSelected.isExpanded());
			if (!currentSelected.isExpanded()) {
				collapseAll(currentSelected);
			}
			if (selected != null && selected.isExpanded()) {
				collapseAll(selected);
			}
			selected = currentSelected;
		}

		return result;
	}

	@Override
	protected void layoutChildren(double x, double y, double w, double h) {

		System.out.println("adjustableFlow.getFirstVisibleCell(): "
			+ adjustableFlow.getFirstVisibleCell());
		System.out.println("needCellsRebuilt: " + needCellsRebuilt);
		System.out.println("needCellsReconfigured: " + needCellsReconfigured);
		System.out.println("needCellsRecreated: " + needCellsRecreated);

		boolean rowCountDirtyOld = false;
		int oldStart = -1;
		if (rowCountDirty && adjustableFlow != null) {
			// && getSelectionModel().getSelectedIndex() != -1) {
			System.out.println("layout");
			rowCountDirtyOld = rowCountDirty;
			oldStart = Math.toIntExact(Math.round(Math.floor((adjustableFlow.getPosition() * cellCountBeforeExpand))));
		}

		super.layoutChildren(x, y, w, h);

		if (adjustableFlow != null && rowCountDirtyOld
			&& oldStart != getSelectionModel().getSelectedIndex()) {
			System.out.println("show");
			System.out.println("getLength(selected): " + getLength(selected));
			System.out.println("getSelectionModel().getSelectedIndex(): "
				+ getSelectionModel().getSelectedIndex());
			System.out.println("oldStart: " + oldStart);
			adjustableFlow.show(getSelectionModel().getSelectedIndex(),
								getLength(selected),
								oldStart);
		}

	}

	private void collapseAll(TreeItem<T> root) {
		root.setExpanded(false);
		for (TreeItem<T> item : root.getChildren()) {
			if (!item.isLeaf()) {
				collapseAll(item);
			}
		}
	}

	@Override
	public double getLength() {
		return (!selected.isLeaf() && selected.isExpanded()) ? selected.getChildren()
																	   .size() + 1 : 1;
	}

	public double getLength(TreeItem<T> selected) {
		return (!selected.isLeaf() && selected.isExpanded())
			? selected.getChildren()
					  .stream()
					  .mapToDouble((value) -> getLength(value))
					  .sum()
			: 1;
	}

	private org.devel.jfxcontrols.scene.control.treetableview.TreeTableView
		getSkinnableC() {
		org.devel.jfxcontrols.scene.control.treetableview.TreeTableView ttv = (org.devel.jfxcontrols.scene.control.treetableview.TreeTableView) getSkinnable();
		return ttv;
	}

	/*
	 * Create a custom flow.
	 */
	@Override
	protected VirtualFlow<TreeTableRow<T>> createVirtualFlow() {
		adjustableFlow = new AdjustableFlow<T, TreeTableRow<T>>(getSkinnable().needsLayoutProperty(),
																getSkinnable().expandedItemCountProperty(),
																10,
																50);
		return adjustableFlow;
	}

	/*
	 * Remove disclosure arrow.
	 */
	@Override
	public TreeTableRow<T> createCell() {
		TreeTableRow<T> cell;

		if (getSkinnable().getRowFactory() != null) {
			cell = getSkinnable().getRowFactory().call(getSkinnable());
		} else {
			cell = new TreeTableRow<T>();
		}

		cell.updateTreeTableView(getSkinnable());
		return cell;
	}

	@Override
	public void dispose() {
		super.dispose();
		adjustableFlow.dispose();
	}

}
