package dk.matzon.oauth.interfaces.mvc;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class SecuredController {

    @GetMapping("/secret")
    public ModelAndView secret(@AuthenticationPrincipal OAuth2User user, Map<String, Object> model) {
        model.put("user", user);
        return new ModelAndView("secured", model);
    }
}
