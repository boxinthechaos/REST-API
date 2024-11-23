package com.example.Login.GreetingController;

import com.example.Login.Greeting.Greeting;
import com.example.Login.GreetingService.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    private final GreetingService greetingService;

    @Autowired
    public GreetingController(GreetingService greetingService){
        this.greetingService = greetingService;
    }

    // GET 요청 (기존)
    @GetMapping
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return greetingService.createGreeting(name);//greetingService에 있는 createGreeting에 name를 반환해 인자로 받아 greeting를 생성함
    }

    // POST 요청 - 새로운 Greeting 생성
    @PostMapping
    public Greeting createGreeting(@RequestBody Greeting newGreeting) {
        return greetingService.saveGreeting(newGreeting); // 반환 해서 greetingService에 있는 saveGreeting에 newGreeting를 보내 저장
    }

    // DELETE 요청 - ID로 Greeting 삭제
    @DeleteMapping("/{id}")
    public String deleteGreeting(@PathVariable Long id) {
        boolean isDeleted = greetingService.deleteGreetingById(id);//greetinggService에 있는 deleteGreetingByid에서 id를 삭제에 관한 참/거짓을 나눔
        return isDeleted ? "Greeting deleted successfully." : "Greeting not found.";//만약 삭제가 참이면 Greeting deleted successfully.를 반환 실패하면 Greeting not found.반환
    }

    // PATCH 요청 - ID로 Greeting 일부 업데이트
    @PatchMapping("/{id}")
    public Greeting updateGreeting(@PathVariable Long id, @RequestBody Greeting updatedGreeting) {
        return greetingService.updateGreeting(id, updatedGreeting);//greetingService에 있는 updateGreeting에 id에 upgreeting를 반환해 업데이트함
    }
}