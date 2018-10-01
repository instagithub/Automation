package customerservice.impl;

import com.pega.TestEnvironment;
import com.pega.page.PortalImpl;
import customerservice.SFAPortal;
import customerservice.tiles.LeftNav;
import customerservice.tiles.TopNav;
import customerservice.tiles.impl.PegaLeftNav;
import customerservice.tiles.impl.PegaTopNav;

public class PegaSFAPortal extends PortalImpl implements SFAPortal {

	public String COPYRIGHT = "Copyright(C)2014 Pegasystems Inc.";
	public String VERSION = "$Id: CSPortalImpl.java 117333 2015-06-18 09:12:21Z MuraliKondapally $";

	private TopNav topNav = null;
	private LeftNav leftNav = null;

	public PegaSFAPortal(TestEnvironment testEnv) {
		super(testEnv);
	}

	@Override
	public TopNav getTopNav() {
		if (topNav == null) {
			topNav = new PegaTopNav(testEnv);
		}
		return topNav;
	}

	@Override
	public LeftNav getLeftNav() {
		if (leftNav == null) {
			leftNav = new PegaLeftNav(testEnv);
		}
		return leftNav;
	}
}
