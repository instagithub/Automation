WinWaitActive("[REGEXPTITLE:(?i)(.*Open.*|.*File Upload.*|.*Choose File to Upload.*)]");
Send($CmdLine[1]);
Send("{ENTER}");