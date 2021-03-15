
package com.pe.workobjects.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.pe.workobjects.DesignerStudioPE;
import com.pega.TestEnvironment;
import com.pega.crm.salesautomation.workobjects.impl.PegaWorkObject;

@SuppressWarnings("unused")
public class DesignerStudioPEImpl extends PegaWorkObject implements DesignerStudioPE {

	public DesignerStudioPEImpl(String frameId, TestEnvironment testEnv) {
		super(frameId, testEnv);
	}
		
	
}