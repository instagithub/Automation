package com.pega.sfa.workobjects;

import com.pega.ri.Wizard;

public interface Pulse extends Wizard{
	boolean isFollowingSectionDisplayed();
	boolean isFollowersSectionDisplayed();
	boolean isFilterButtonDisplayed();
	void enterCommentsinPulse(String pulseComment);
	void clickPost();
	String getFirstPulsePost();
	boolean isSalesCoachWidgetDisplayed();
}
