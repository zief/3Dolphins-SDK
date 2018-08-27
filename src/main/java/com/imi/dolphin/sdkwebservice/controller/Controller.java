package com.imi.dolphin.sdkwebservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.imi.dolphin.sdkwebservice.model.ExtensionRequest;
import com.imi.dolphin.sdkwebservice.model.ExtensionResult;
import com.imi.dolphin.sdkwebservice.property.AppProperties;
import com.imi.dolphin.sdkwebservice.service.IService;

@RestController
public class Controller {

	@Autowired
	private AppProperties appProperties;

	@Autowired
	IService svcService;

	@RequestMapping("/forms")
	public String getStarted() {
		return "Hello Form, service port: " + appProperties.getServicePort() + ", " + appProperties.getFormId();
	}

	@RequestMapping("/status/")
	@PostMapping
	public ExtensionResult doGetSrnResult(@RequestBody ExtensionRequest extensionRequest) {
		return svcService.getSrnResult(extensionRequest);
	}

	@RequestMapping("/customers")
	@PostMapping
	public ExtensionResult doQueryCustomerInfo(@RequestBody ExtensionRequest extensionRequest) {
		return svcService.getCustomerInfo(extensionRequest);
	}

	@RequestMapping("/productinfo")
	@PostMapping
	public ExtensionResult doQueryProductInfo(@RequestBody ExtensionRequest extensionRequest) {
		return svcService.getProductInfo(extensionRequest);
	}

	@RequestMapping("/messages")
	@PostMapping
	public ExtensionResult doGetMessages(@RequestBody ExtensionRequest extensionRequest) {
		return svcService.getMessageBody(extensionRequest);
	}

	@RequestMapping("/quickreplies")
	@PostMapping
	public ExtensionResult doBuildQuickReplies(@RequestBody ExtensionRequest extensionRequest) {
		return svcService.getQuickReplies(extensionRequest);
	}

	@RequestMapping("/form")
	@PostMapping
	public ExtensionResult doBuildForm(@RequestBody ExtensionRequest extensionRequest) {
		return svcService.getForms(extensionRequest);
	}

	@RequestMapping("/button")
	@PostMapping
	public ExtensionResult doBuildButton(@RequestBody ExtensionRequest extensionRequest) {
		return svcService.getButtons(extensionRequest);
	}

}