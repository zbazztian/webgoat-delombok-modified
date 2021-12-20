package org.owasp.webgoat.service;

import org.owasp.webgoat.lessons.Lesson;
import org.owasp.webgoat.lessons.LessonInfoModel;
import org.owasp.webgoat.session.WebSession;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>LessonInfoService class.</p>
 *
 * @author dm
 * @version $Id: $Id
 */
@RestController
public class LessonInfoService {
    private final WebSession webSession;

    /**
     * <p>getLessonInfo.</p>
     *
     * @return a {@link LessonInfoModel} object.
     */
    @RequestMapping(path = "/service/lessoninfo.mvc", produces = "application/json")
    @ResponseBody
    public LessonInfoModel getLessonInfo() {
        Lesson lesson = webSession.getCurrentLesson();
        return new LessonInfoModel(lesson.getTitle(), false, false, false);
    }

    public LessonInfoService(final WebSession webSession) {
        this.webSession = webSession;
    }
}
