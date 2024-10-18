package ru.expiro.vkbotservice;

import com.vk.api.sdk.exceptions.ApiException;
import com.vk.api.sdk.exceptions.ClientException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) throws ClientException, InterruptedException, ApiException {
//		vkBotTest();
		SpringApplication.run(DemoApplication.class, args);
	}

//	private static void vkBotTest() throws ApiException, ClientException, InterruptedException {
//		TransportClient transportClient = new HttpTransportClient();
//		VkApiClient vk = new VkApiClient(transportClient);
//		GroupActor actor = new GroupActor(226977622L, "vk1.a.bgbWzpEIZ2JiG1jm8t_oZjb_bkAEXvOvouXpGK3tisfgCgRBxMR2KXZnuhEoqoXS2UW2bWfyZFk8j7w2zQSySuqWc9HovR-Sg25dW8GmVRuFTl6GkvXJuVrFM8_bVYizKal2J55OgZcB2FnAw0teRT-zVGd5fGgLeXvIeJixYlP8ouRDCjLu0xSXhCIyHTBjBqCo3Bju2gUxSrqSxYy1yA");
//		int ts = vk.messages().getLongPollServer(actor).execute().getTs();
//		while (true) {
//			MessagesGetLongPollHistoryQuery historyQuery = vk.messages().getLongPollHistory(actor).ts(ts);
//			List<Message> messages = historyQuery.execute().getMessages().getItems();
//			vk.messages().sendDeprecated(actor).userId();
//			if (!messages.isEmpty()) {
//				messages.forEach(message -> {
//					System.out.printf(message.toString());
//					try {
//						if (message.getText().equals("При вет")) {
//							System.out.printf("Привет!");
//						}
//					} catch (ApiException | ClientException e) {
//						e.printStackTrace();
//					}
//				});
//			}
//			ts = vk.messages().getLongPollServer(actor).execute().getTs();
//			Thread.sleep(500);
//		}
//	}

}
