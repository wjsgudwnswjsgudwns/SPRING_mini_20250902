package com.jhj.cinema.command;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface CCommand {

	public void execute(Model model,HttpServletRequest request);
}
