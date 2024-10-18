package ru.expiro.vkbotservice;

import com.vk.api.sdk.client.TransportClient;
import com.vk.api.sdk.client.VkApiClient;
import com.vk.api.sdk.client.actors.GroupActor;
import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import com.vk.api.sdk.httpclient.HttpTransportClient;
import com.vk.api.sdk.objects.messages.Message;
import com.vk.api.sdk.queries.messages.MessagesGetLongPollHistoryQuery;
import org.junit.jupiter.api.Test;

import java.util.List;

public class VkSdkTests {

    @Test
    public void vkBotTest() throws ApiException, ClientException, InterruptedException{
        TransportClient transportClient = new HttpTransportClient();
        VkApiClient vk = new VkApiClient(transportClient);
        GroupActor actor = new GroupActor(226977622L, "vk1.a.bgbWzpEIZ2JiG1jm8t_oZjb_bkAEXvOvouXpGK3tisfgCgRBxMR2KXZnuhEoqoXS2UW2bWfyZFk8j7w2zQSySuqWc9HovR-Sg25dW8GmVRuFTl6GkvXJuVrFM8_bVYizKal2J55OgZcB2FnAw0teRT-zVGd5fGgLeXvIeJixYlP8ouRDCjLu0xSXhCIyHTBjBqCo3Bju2gUxSrqSxYy1yA");
        int ts = vk.messages().getLongPollServer(actor).execute().getTs();
        while (true) {

            ts = vk.messages().getLongPollServer(actor).execute().getTs();
            Thread.sleep(500);
        }
    }
}
