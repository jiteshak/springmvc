package com.te.springmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.te.springmvc.entity.dto.EmployeeDto;
import com.te.springmvc.entity.dto.EmployeeUpdatedDto;
import com.te.springmvc.service.AppService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor

@RequestMapping(path = "/c1")
public class AppController {

	public final AppService appService;

	@GetMapping(path = "welcome")
	public String welcome() {

		return "registerpage";
	}

	@PostMapping(path = "/register")
	public String register(@ModelAttribute EmployeeDto employeeDto, Model model) {

		EmployeeDto created = appService.register(employeeDto);

		model.addAttribute("name", created.getName());
		model.addAttribute("email", created.getEmail());
		model.addAttribute("age", created.getAge());

		return "profile";
	}

	/*
	 * @GetMapping(path = "/register") public String
	 * getEmployeeDetails(@ModelAttribute EmployeeDto employeeDto, Model model) {
	 * 
	 * EmployeeDto employeeDetails = appService.getEmployeeDetails(employeeId);
	 * 
	 * model.addAttribute("name", employeeDetails.getName());
	 * model.addAttribute("email", employeeDetails.getEmail());
	 * model.addAttribute("age", employeeDetails.getAge());
	 * 
	 * return "profile";
	 * 
	 * }
	 */
	@GetMapping(path = "/update")
	public String register() {

		return "update";
	}

	/*
	 * @PostMapping(path = "/employee/update") public String
	 * updateEmployeeDetails(@ModelAttribute EmployeeUpdatedDto employeeUpdatedDto,
	 * Model model) { EmployeeDto updateEmployeeDetails =
	 * appService.updateEmployeeDetails(employeeUpdatedDto.getEmployeeId(),
	 * employeeUpdatedDto);
	 * 
	 * model.addAttribute("name", updateEmployeeDetails.getName());
	 * model.addAttribute("email", updateEmployeeDetails.getEmail());
	 * model.addAttribute("age", updateEmployeeDetails.getAge());
	 * 
	 * return "profile"; }
	 */

	@GetMapping(path = "/delete")
	public String delete() {
		return "delete";
	}

	@PostMapping(path = "/employee/delete")
	public String deleteEmployeeDetails(@RequestParam(name = "employeeId") int employeeId, Model model) {

		boolean isDeleted = appService.deleteEmployeeDetails(employeeId);

		model.addAttribute("employeeId", "employeeId");
		model.addAttribute("isDeleted", isDeleted);

		return "isDeleted";
	}

}
