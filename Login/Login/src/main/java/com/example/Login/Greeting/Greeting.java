package com.example.Login.Greeting;

import lombok.Getter;

@Getter
public class Greeting {
    private final long id;
    private final String content;

    public Greeting(long id, String content) {
        this.id = id;
        this.content = content;
    }

    // 새로운 Greeting을 생성하는 메서드
    public Greeting withId(long newId) {
        return new Greeting(newId, this.content);
    }

    public Greeting withContent(String newContent) {
        return new Greeting(this.id, newContent);
    }
}
