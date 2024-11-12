package com.example.Login.GreetingService;

import com.example.Login.Greeting.Greeting;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class GreetingService {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private final Map<Long, Greeting> greetingRepository = new ConcurrentHashMap<>();

    // 기존 메서드 - 새 인사말 생성
    public Greeting createGreeting(String name) {
        Greeting greeting = new Greeting(counter.incrementAndGet(), String.format(template, name));
        //윗부분: counter값을 1증가 시키는 incrementAndGet()코드로 고유한 id를 생성하는 코드
        //윗부분: template의 "Hello, %s!"와 같은 형식으로 format(template,name)부분으로 "Hello, name!"로 content를 생성
        greetingRepository.put(greeting.getId(), greeting);
        //윗부분:Greeting 객체를 생성하고 Greeting 객체의  id를 Repository에 저장한다
        return greeting;//greeting를 반환한다
    }

    // POST 메서드를 위한 메서드 - 새 Greeting 저장
    public Greeting saveGreeting(Greeting newGreeting) {
        long newId = counter.incrementAndGet();
        //윗부분: counter의 값을 1증가시켜 새로운 id를 만드는 코드이다
        Greeting greetingWithId = new Greeting(newId, newGreeting.getContent());
        //윗부분:newGreeting에서 content를 가져오고 newId와 newGreeting으로 새로운 Greeting 객체를 생성한다
        greetingRepository.put(greetingWithId.getId(), greetingWithId);
        //윗부분:윗부분에서 만들어진 새로운 Greeting 객체를 Repository에 저장한다
        return greetingWithId;//greetingWithId를 반환한다
    }

    // DELETE 메서드를 위한 메서드 - ID로 Greeting 삭제
    public boolean deleteGreetingById(Long id) {
        return greetingRepository.remove(id) != null;//삭제된 객체가 있다면 true를 반환하고 삭제된 객체가 없다면 falsㄷ를 반환한다
    }

    // PATCH 메서드를 위한 메서드 - ID로 Greeting 일부 업데이트
    public Greeting updateGreeting(Long id, Greeting updatedGreeting) {
        Greeting existingGreeting = greetingRepository.get(id);
        //윗부분: Repository에서 id를 existingGreeting에 할당한다
        if (existingGreeting != null) { // existingGreeting가 null이 아닌지 판단한다 만약에 null이 맞다면 if이하를 실행한다
            Greeting updated = existingGreeting.withContent(updatedGreeting.getContent());
            //윗부분: 새로운 content로 Greeting 객체를 생성
            greetingRepository.put(id, updated);
            //윗부분: Repository에 id와 updated된 content를 저장한다
            return updated;// updated를 반환한다
        }
        return null; // 해당 ID가 없는 경우
    }
}
