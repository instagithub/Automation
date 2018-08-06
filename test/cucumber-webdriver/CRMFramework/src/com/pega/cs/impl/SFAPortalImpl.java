package com.pega.cs.impl;

import com.pega.TestEnvironment;
import com.pega.page.PortalImpl;
import com.pega.cs.SFAPortal;
import com.pega.cs.tiles.LeftNav;
import com.pega.cs.tiles.impl.LeftNavImpl;
import com.pega.cs.tiles.TopNav;
import com.pega.cs.tiles.impl.TopNavImpl;

public class SFAPortalImpl extends PortalImpl implements SFAPortal {

	public String COPYRIGHT = "Copyright(C)2014 Pegasystems Inc.";
	public String VERSION = "$Id: CSPortalImpl.java 117333 2015-06-18 09:12:21Z MuraliKondapally $";

	private TopNav topNav = null;
	private LeftNav leftNav = null;

	public SFAPortalImpl(TestEnvironment testEnv) {
		super(testEnv);
	}

	@Override
	public TopNav getTopNav() {
		if (topNav == null) {
			topNav = new TopNavImpl(testEnv);
		}
		return topNav;
	}

	@Override
	public LeftNav getLeftNav() {
		if (leftNav == null) {
			leftNav = new LeftNavImpl(testEnv);
		}
		return leftNav;
	}
}
