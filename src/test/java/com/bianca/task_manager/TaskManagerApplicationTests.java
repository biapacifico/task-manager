package com.bianca.task_manager;

import com.bianca.task_manager.entity.Task;
import com.bianca.task_manager.repository.TaskRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TaskManagerApplicationTests {
    @Autowired
    private WebTestClient webTestClient;
    @Autowired
    private TaskRepository taskRepository;

	@Test
	void testCreateTaskSuccess() {
        var task = new Task("watch star wars", "watch first trilogy", false, 3);

        webTestClient
                .post()
                .uri("/tasks")
                .bodyValue(task)
                .exchange()
                .expectStatus().isOk()
                .expectBody()
                .jsonPath("$").isArray()
                .jsonPath("$.length()").isEqualTo(1)
                .jsonPath("$[0].name").isEqualTo(task.getName())
                .jsonPath("$[0].description").isEqualTo(task.getDescription())
                .jsonPath("$[0].done").isEqualTo(task.isDone())
                .jsonPath("$[0].priority").isEqualTo(task.getPriority());
    }

    @Test
    void testCreateTaskFailure() {
        webTestClient
                .post()
                .uri("/tasks")
                .bodyValue(
                        new Task("", "", false, 0)
                ).exchange()
                .expectStatus().isBadRequest();
    }
}