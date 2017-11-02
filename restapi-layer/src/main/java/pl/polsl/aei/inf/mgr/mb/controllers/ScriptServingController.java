package pl.polsl.aei.inf.mgr.mb.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/scripts",method = RequestMethod.GET)
public class ScriptServingController
{
	@RequestMapping
	public String serveScripts()
	{
		return "scripts";
	}
}
