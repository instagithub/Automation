/*
 * $Id$
 *
 * Copyright (c) 2018  Pegasystems Inc.
 * All rights reserved.
 *
 * This  software  has  been  provided pursuant  to  a  License
 * Agreement  containing  restrictions on  its  use.   The  software
 * contains  valuable  trade secrets and proprietary information  of
 * Pegasystems Inc and is protected by  federal   copyright law.  It
 * may  not be copied,  modified,  translated or distributed in  any
 * form or medium,  disclosed to third parties or used in any manner
 * not provided for in  said  License Agreement except with  written
 * authorization from Pegasystems Inc.
*/

package com.pega.pm.impl.dialog;

import com.pega.TestEnvironment;
import com.pega.framework.PegaWebDriver;
import com.pega.framework.PegaWebElement;
import com.pega.framework.elmt.Frame;
import com.pega.pm.dialog.ModalDialog;

public class PegaModalDialog implements ModalDialog {
	protected PegaWebDriver pegaDriver;
	protected TestEnvironment testEnv;
	protected PegaWebElement elmt;
	
	public PegaModalDialog(Frame elmt) {
		this.elmt = elmt;
		this.testEnv = elmt.getTestEnvironment();
		this.pegaDriver = testEnv.getPegaDriver();
	}

	public void apply() {
		elmt.findElement(APPLY_BUTTON).click();
	}

	public void close() {
		elmt.findElement(CLOSE_BUTTON).click();

	}
	public void submit() {
		elmt.findElement(SUBMIT_BUTTON).click();
		
	}
	public void cancel() {
		elmt.findElement(CANCEL_BUTTON);
		
	}

}
