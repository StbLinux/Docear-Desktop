/*
 *  Freeplane - mind map editor
 *  Copyright (C) 2008 Joerg Mueller, Daniel Polansky, Christian Foltin, Dimitry Polivaev
 *
 *  This file is modified by Dimitry Polivaev in 2008.
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
package org.freeplane.features.mode.browsemode;

import org.freeplane.features.icon.UIIcon;
import org.freeplane.features.icon.factory.IconStoreFactory;
import org.freeplane.features.map.NodeModel;
import org.freeplane.features.mode.Controller;
import org.freeplane.features.mode.ModeController;
import org.freeplane.features.note.NoteController;
import org.freeplane.features.note.NoteModel;

public class BModeController extends ModeController {
	static public final String MODENAME = "Browse";
	private UIIcon noteIcon;

	public BModeController(final Controller controller) {
		super(controller);
	}

	@Override
	public String getModeName() {
		return BModeController.MODENAME;
	}

	public void setNoteIcon(final NodeModel node) {
		final String noteText = NoteModel.getNoteText(node);
		if (noteText != null && !noteText.equals("")) {
			if (noteIcon == null) {
				noteIcon = IconStoreFactory.create().getUIIcon("knotes.png");
			}
			node.setStateIcon(NoteController.NODE_NOTE_ICON, noteIcon, true);
		}
		for (final NodeModel child : getMapController().childrenUnfolded(node)) {
			setNoteIcon(child);
		}
	}
}