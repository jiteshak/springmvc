package com.te.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.te.springmvc.entity.dto.EmployeeDto;
import com.te.springmvc.entity.dto.EmployeeUpdatedDto;
import com.te.springmvc.service.AppService;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@RequestMapping(path = "/j1")
public class SurakshaController {

	private final AppService appService;

	@GetMapping(path = "/test")
	public String test() {
		return "welcome";
	}

	@GetMapping(path = "/register")
	public String getRegistrationForm() {
		return "registerpage";
	}

	@PostMapping(path = "/save")
	public String saveDetails(@ModelAttribute EmployeeDto employeeDto, Model model) {

		appService.register(employeeDto);
		model.addAttribute("name", employeeDto.getName());
		model.addAttribute("email", employeeDto.getEmail());
		model.addAttribute("age", employeeDto.getAge());

		return "profile";
	}

	@GetMapping(path = "/update")
	public String updateform() {
		return "update";
	}

	@PostMapping(path = "/updateprofile")
	public String updateDetails(@ModelAttribute EmployeeUpdatedDto updatedDto, Model model) {
		appService.updateEmployeeDetails(updatedDto.getEmployeeId(), updatedDto);

		model.addAttribute("name", updatedDto.getName());
		model.addAttribute("email", updatedDto.getEmail());
		model.addAttribute("age", updatedDto.getAge());
		return "updatedprofile";
	}

	@GetMapping("/delete")
	public String deleteForm() {
		return "delete";
	}

	@PostMapping(path = "/deleteemp")
	public String deleteEmployees(@RequestParam (name="employeeId") int empid) {
		appService.deleteEmployeeDetails(empid);
		return "isDeleted";
		
	}
}
























