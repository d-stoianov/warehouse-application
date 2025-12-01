package warehouse.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Auth", description = "Endpoints for managing authentication")
@RestController
@RequestMapping("/auth")
public class AuthController {
}
