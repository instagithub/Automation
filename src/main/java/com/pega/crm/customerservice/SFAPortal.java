package customerservice;

import customerservice.tiles.LeftNav;
import customerservice.tiles.TopNav;
import com.pega.page.Portal;

public interface SFAPortal extends Portal { 

        String COPYRIGHT = "Copyright (C) 2014  Pegasystems Inc."; 
        String VERSION = "$Id: CSPortalImpl.java 117333 2015-06-18 09:12:21Z MuraliKondapally $"; 

        TopNav getTopNav(); 
        
        LeftNav getLeftNav(); 
        
        
}

