package com.eliza.elizachat.service;

import com.eliza.elizachat.model.CustomPattern;
import com.eliza.elizachat.model.Question;
import com.eliza.elizachat.model.Response;
import com.eliza.elizachat.utils.Utils;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.regex.Matcher;

@Service
public class ChatService {
    private final Utils utils;

    public ChatService(Utils util) {
        this.utils = util;
    }

    public Response sendResponse(Question question) {
        Map<CustomPattern, List<String>> qa = utils.pullResponses();
        Response defaultResponse = new Response("I have no clue what are talking about");
        List<String> rs = new ArrayList<>();
        qa.forEach((k,v) -> {
            Matcher m = k.getPattern().matcher(question.getMessage());
            if (m.find()) {
                String r = v.get(new Random().nextInt(v.size()));
                String focusPart = utils.getCorrectPronouns(m.group(k.getGroup()));
                r = r.replace("(insert)", focusPart);
                rs.add(r);
            }
        });
        if (!rs.isEmpty()) {
            return new Response(rs.get(0));
        }
        return defaultResponse;
    }
}
