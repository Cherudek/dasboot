package com.gregorio.dasboot;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.reactive.function.client.WebClient;

@RestController
public class Something {

    @Value("${bean.name:ABC}")
    private String beanName;

    private WebClient webClient;

    public Something(WebClient webClient) {
        this.webClient = webClient;
        System.out.println(" >> This is really Something << ");
    }

    @GetMapping
    String getSomething()  {
        return "Initializing bean: " + beanName;
    }

    @GetMapping ("/reverse")
    String getReversed() {
        return webClient.get()
            .uri("/reverse?inbound={inboundText}", "This is my String!")
            .header("Content-Type", "application/json")
            .retrieve()
            .bodyToMono(String.class)
            .block();
    }
}
