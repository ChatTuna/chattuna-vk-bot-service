package ru.expiro.vkbotservice.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.expiro.vkbotservice.service.VkBotService;

@RestController
@RequestMapping("contr")
public class Controller {
    VkBotService vkBotService;

    Controller(VkBotService vkBotService) {
        this.vkBotService = vkBotService;
    }
    @PostMapping("postMsg")
    public void PostMessage() {
        vkBotService.sendMessageById("str", 218346845L);
    }
}
