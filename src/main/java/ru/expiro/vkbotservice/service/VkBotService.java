package ru.expiro.vkbotservice.service;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.messages.Message;
import com.vk.api.sdk.queries.messages.MessagesGetLongPollHistoryQuery;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class VkBotService {
    private final TransportClient transportClient;
    private final VkApiClient vk;
    private final GroupActor actor;
    private final long groupId = 226977622L;
    private final String accessToken = "vk1.a.bgbWzpEIZ2JiG1jm8t_oZjb_bkAEXvOvouXpGK3tisfgCgRBxMR2KXZnuhEoqoXS2UW2bWfyZFk8j7w2zQSySuqWc9HovR-Sg25dW8GmVRuFTl6GkvXJuVrFM8_bVYizKal2J55OgZcB2FnAw0teRT-zVGd5fGgLeXvIeJixYlP8ouRDCjLu0xSXhCIyHTBjBqCo3Bju2gUxSrqSxYy1yA";
    private int ts;
    private Random random;


    public VkBotService() throws ApiException, ClientException, InterruptedException{
        transportClient = new HttpTransportClient();
        vk = new VkApiClient(transportClient);
        actor = new GroupActor(groupId, accessToken);
        ts = vk.messages().getLongPollServer(actor).execute().getTs();
        random = new Random();
    }

    public void sendMessageById(String message, Long id) {
        try{
            vk.messages().sendDeprecated(actor).userId(id).message(message).randomId(random.nextInt(10000)).execute();
            //ts = vk.messages().getLongPollServer(actor).execute().getTs();
        }
        catch (ClientException e) {
            throw new RuntimeException(e);
        } catch (ApiException e) {
            throw new RuntimeException(e);
        }
    }
}

