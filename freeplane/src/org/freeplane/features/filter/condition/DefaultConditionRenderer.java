/*
 *  Freeplane - mind map editor
 *  Copyright (C) 2008 Dimitry Polivaev
 *
 *  This file author is Dimitry Polivaev
 *
 *  This program is free software: you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License as published by
 *  the Free Software Foundation, either version 2 of the License, or
 *  (at your option) any later version.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package org.freeplane.features.filter.condition;

import java.awt.Component;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTable;
import javax.swing.ListCellRenderer;
import javax.swing.table.TableCellRenderer;

import org.freeplane.features.icon.UIIcon;

/**
 * @author Dimitry Polivaev
 */
public class DefaultConditionRenderer implements ListCellRenderer, TableCellRenderer {
	private final String noValueText;

	public DefaultConditionRenderer(String noValueText) {
	    this.noValueText = noValueText;
    }

	/*
	 * (non-Javadoc)
	 * @see
	 * javax.swing.ListCellRenderer#getListCellRendererComponent(javax.swing
	 * .JList, java.lang.Object, int, boolean, boolean)
	 */
	public Component getListCellRendererComponent(final JList list, final Object value, final int index,
	                                              final boolean isSelected, final boolean cellHasFocus) {
		Component cellRendererComponent = getCellRendererComponent(value, isSelected);
        if (isSelected) {
        	cellRendererComponent.setBackground(list.getSelectionBackground());
        	cellRendererComponent.setForeground(list.getSelectionForeground());
        }
        else {
        	cellRendererComponent.setBackground(list.getBackground());
        	cellRendererComponent.setForeground(list.getForeground());
        }
		return cellRendererComponent;
	}
	
	private Component getCellRendererComponent(final Object value, final boolean isSelected) {
		if (value == null) {
			return new JLabel(noValueText);
		}
		JComponent component;
		if (value instanceof UIIcon) {
			component = new JLabel(((UIIcon) value).getIcon());
		}
		else if (value instanceof ASelectableCondition) {
			final ASelectableCondition cond = (ASelectableCondition) value;
			component = cond.getListCellRendererComponent();
		}
		else {
			component = new JLabel(value.toString());
		}
		component.setOpaque(true);
		component.setAlignmentX(Component.LEFT_ALIGNMENT);
		return component;
	}

	public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                                                   int row, int column) {
		Component cellRendererComponent = getCellRendererComponent(value, isSelected);
	       if (isSelected) {
	    	   cellRendererComponent.setBackground(table.getSelectionBackground());
	    	   cellRendererComponent.setForeground(table.getSelectionForeground());
	        }
	        else {
	        	cellRendererComponent.setBackground(table.getBackground());
	        	cellRendererComponent.setForeground(table.getForeground());
	        }
		return cellRendererComponent;
    }
}