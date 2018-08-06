package com.pega.cs;

import com.pega.page.Portal;
import com.pega.cs.tiles.LeftNav;
import com.pega.cs.tiles.TopNav;

public interface SFAPortal extends Portal { 

        String COPYRIGHT = "Copyright (C) 2014  Pegasystems Inc."; 
        String VERSION = "$Id: CSPortalImpl.java 117333 2015-06-18 09:12:21Z MuraliKondapally $"; 

        TopNav getTopNav(); 
        
        LeftNav getLeftNav(); 
        
        
}

