package com.eliza.elizachat.utils;

import com.eliza.elizachat.model.CustomPattern;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Component
public class Utils {

    public Map<CustomPattern, List<String>> pullResponses() {
        Map<CustomPattern, List<String>> responses = new HashMap<>();
        Pattern pattern = Pattern.compile("(I need )(.*)", Pattern.CASE_INSENSITIVE);
        responses.put(new CustomPattern(pattern, 2), new ArrayList<>(Arrays.asList(
                "Why do you need (insert)?",
                "Would it really help you to get (insert)?",
                "Are you sure you need (insert)?",
                "Why do you think you need (insert)?"
        )));
        pattern = Pattern.compile("(Why (don\\'?t|do not) you )(.*)\\??", Pattern.CASE_INSENSITIVE);
        responses.put(new CustomPattern(pattern, 3), new ArrayList<>(Arrays.asList(
                "Do you really think I don't (insert)?",
                "Perhaps eventually I will (insert).",
                "Do you really want me to (insert)?"
        )));
        pattern = Pattern.compile("(Why (can\\'?t|cannot) I )(.*)\\??", Pattern.CASE_INSENSITIVE);
        responses.put(new CustomPattern(pattern, 3), new ArrayList<>(Arrays.asList(
                "Do you think you should be able to (insert)?",
                "If you could (insert), what would you do?",
                "I don't know - why can't you (insert)?",
                "Have you really tried?"
        )));
        pattern = Pattern.compile("(I (can\\'?t|cannot) )(.*)", Pattern.CASE_INSENSITIVE);
        responses.put(new CustomPattern(pattern, 3), new ArrayList<>(Arrays.asList(
                "How do you know you can't (insert)?",
                "Perhaps you could (insert) if you tried.",
                "What would it take for you to (insert)?"
        )));
        pattern = Pattern.compile("(I am )(.*)", Pattern.CASE_INSENSITIVE);
        responses.put(new CustomPattern(pattern, 2), new ArrayList<>(Arrays.asList(
                "Did you come to me because you are (insert)?",
                "How long have you been (insert)?",
                "How do you feel about being (insert)?"
        )));
        pattern = Pattern.compile("(I\\'?m )(.*)", Pattern.CASE_INSENSITIVE);
        responses.put(new CustomPattern(pattern, 2), new ArrayList<>(Arrays.asList(
                "How does being (insert) make you feel?",
                "Do you enjoy being (insert)?",
                "Why do you tell me you're (insert)?",
                "Why do you think you're (insert)?"
        )));
        pattern = Pattern.compile("(Are you )(.*)\\??", Pattern.CASE_INSENSITIVE);
        responses.put(new CustomPattern(pattern, 2), new ArrayList<>(Arrays.asList(
                "Why does it matter whether I am (insert)?",
                "Would you prefer it if I were not (insert)?",
                "Perhaps you believe I am (insert).",
                "I may be (insert) - what do you think?"
        )));
        pattern = Pattern.compile("(What )(.*)", Pattern.CASE_INSENSITIVE);
        responses.put(new CustomPattern(pattern, 2), new ArrayList<>(Arrays.asList(
                "Why do you ask?",
                "How would an answer to that help you?",
                "What do you think?"
        )));
        pattern = Pattern.compile("(How )(.*)", Pattern.CASE_INSENSITIVE);
        responses.put(new CustomPattern(pattern, 2), new ArrayList<>(Arrays.asList(
                "How do you suppose?",
                "Perhaps you can answer your own question.",
                "What is it you're really asking?"
        )));
        pattern = Pattern.compile("(Because )(.*)", Pattern.CASE_INSENSITIVE);
        responses.put(new CustomPattern(pattern, 2), new ArrayList<>(Arrays.asList(
                "Is that the real reason?",
                "What other reasons come to mind?",
                "Does that reason apply to anything else?",
                "If (insert), what else must be true?"
        )));
        pattern = Pattern.compile("(.*)( sorry )(.*)", Pattern.CASE_INSENSITIVE);
        responses.put(new CustomPattern(pattern, 3), new ArrayList<>(Arrays.asList(
                "There are many times when no apology is needed.",
                "What feelings do you have when you apologize?"
        )));
        pattern = Pattern.compile("(Hello)(.*)", Pattern.CASE_INSENSITIVE);
        responses.put(new CustomPattern(pattern, 2), new ArrayList<>(Arrays.asList(
                "Hello... I'm glad you could drop by today.",
                "Hi there... how are you today?",
                "Hello, how are you feeling today?"
        )));
        pattern = Pattern.compile("(I think )(.*)", Pattern.CASE_INSENSITIVE);
        responses.put(new CustomPattern(pattern, 2), new ArrayList<>(Arrays.asList(
                "Do you doubt (insert)?",
                "Do you really think so?",
                "But you're not sure (insert)?"
        )));
        pattern = Pattern.compile("(.*)( friend|friends )(.*)", Pattern.CASE_INSENSITIVE);
        responses.put(new CustomPattern(pattern, 3), new ArrayList<>(Arrays.asList(
                "Tell me more about your friends.",
                "When you think of a friend, what comes to mind?",
                "Why don't you tell me about a childhood friend?"
        )));
        pattern = Pattern.compile("(Yes|Of course)", Pattern.CASE_INSENSITIVE);
        responses.put(new CustomPattern(pattern, 1), new ArrayList<>(Arrays.asList(
                "You seem quite sure.",
                "OK, but can you elaborate a bit?"
        )));
        pattern = Pattern.compile("(.*)( computer | AI |Artificial Intelligence)(.*)", Pattern.CASE_INSENSITIVE);
        responses.put(new CustomPattern(pattern, 2), new ArrayList<>(Arrays.asList(
                "Are you really talking about me?",
                "Does it seem strange to talk to a (insert)?",
                "How do (insert) make you feel?",
                "Do you feel threatened by (insert)?"
        )));
        pattern = Pattern.compile("(Is it )(.*)", Pattern.CASE_INSENSITIVE);
        responses.put(new CustomPattern(pattern, 2), new ArrayList<>(Arrays.asList(
                "Do you think it is (insert)?",
                "Perhaps it's (insert) - what do you think?",
                "If it were (insert), what would you do?",
                "It could well be that (insert)."
        )));
        pattern = Pattern.compile("(It is|It's )(.*)", Pattern.CASE_INSENSITIVE);
        responses.put(new CustomPattern(pattern, 2), new ArrayList<>(Arrays.asList(
                "You seem very certain.",
                "If I told you that it probably isn't %1, what would you feel?"
        )));
        pattern = Pattern.compile("(Can you )(.*)\\??", Pattern.CASE_INSENSITIVE);
        responses.put(new CustomPattern(pattern, 2), new ArrayList<>(Arrays.asList(
                "Perhaps you don't want to (insert).",
                "Do you want to be able to (insert)?",
                "If you could (insert), would you?"
        )));
        pattern = Pattern.compile("(Can I )(.*)\\??", Pattern.CASE_INSENSITIVE);
        responses.put(new CustomPattern(pattern, 2), new ArrayList<>(Arrays.asList(
                "Why do you ask?",
                "How would an answer to that help you?",
                "What do you think?"
        )));
        pattern = Pattern.compile("(You are )(.*)", Pattern.CASE_INSENSITIVE);
        responses.put(new CustomPattern(pattern, 2), new ArrayList<>(Arrays.asList(
                "Why do you think I am (insert)?",
                "Does it please you to think that I'm (insert)?",
                "Perhaps you would like me to be(insert).",
                "Perhaps you're really talking about yourself?"
        )));
        pattern = Pattern.compile("(You\\'?re )(.*)", Pattern.CASE_INSENSITIVE);
        responses.put(new CustomPattern(pattern, 2), new ArrayList<>(Arrays.asList(
                "Why do you say I am (insert)?",
                "Why do you think I am (insert)?",
                "Are we talking about you, or me?"
        )));
        pattern = Pattern.compile("(I (don\\'?t|do not) )(.*)", Pattern.CASE_INSENSITIVE);
        responses.put(new CustomPattern(pattern, 3), new ArrayList<>(Arrays.asList(
                "Don't you really (insert)?",
                "Why don't you (insert)?",
                "Do you want to (insert)?"
        )));
        pattern = Pattern.compile("(I feel )(.*)", Pattern.CASE_INSENSITIVE);
        responses.put(new CustomPattern(pattern, 2), new ArrayList<>(Arrays.asList(
                "Good, tell me more about these feelings.",
                "Do you often feel (insert)?",
                "When do you usually feel (insert)?",
                "When you feel (insert), what do you do?"
        )));
        pattern = Pattern.compile("(I have )(.*)", Pattern.CASE_INSENSITIVE);
        responses.put(new CustomPattern(pattern, 2), new ArrayList<>(Arrays.asList(
                "Why do you tell me that you've (insert)?",
                "Have you really (insert)?",
                "Now that you have (insert), what will you do next?"
        )));
        pattern = Pattern.compile("(I would )(.*)", Pattern.CASE_INSENSITIVE);
        responses.put(new CustomPattern(pattern, 2), new ArrayList<>(Arrays.asList(
                "Could you explain why you would (insert)?",
                "Why would you (insert)?",
                "Who else knows that you would (insert)?"
        )));
        pattern = Pattern.compile("(Is there )(.*)", Pattern.CASE_INSENSITIVE);
        responses.put(new CustomPattern(pattern, 2), new ArrayList<>(Arrays.asList(
                "Do you think there is (insert)?",
                "It's likely that there is (insert).",
                "Would you like there to be (insert)?"
        )));
        pattern = Pattern.compile("(My )(.*)", Pattern.CASE_INSENSITIVE);
        responses.put(new CustomPattern(pattern, 2), new ArrayList<>(Arrays.asList(
                "I see, your (insert).",
                "Why do you say that your (insert)?",
                "When your (insert), how do you feel?"
        )));
        pattern = Pattern.compile("(You )(.*)", Pattern.CASE_INSENSITIVE);
        responses.put(new CustomPattern(pattern, 2), new ArrayList<>(Arrays.asList(
                "We should be discussing you, not me.",
                "Why do you say that about me?",
                "Why do you care whether I (insert)?"
        )));
        pattern = Pattern.compile("(Why )(.*)", Pattern.CASE_INSENSITIVE);
        responses.put(new CustomPattern(pattern, 2), new ArrayList<>(Arrays.asList(
                "Why don't you tell me the reason why (insert)?",
                "Why do you think (insert)?"
        )));
        pattern = Pattern.compile("(I want )(.*)", Pattern.CASE_INSENSITIVE);
        responses.put(new CustomPattern(pattern, 2), new ArrayList<>(Arrays.asList(
                "What would it mean to you if you got (insert)?",
                "Why do you want (insert)?",
                "What would you do if you got (insert)?",
                "If you got (insert), then what would you do?"
        )));
        pattern = Pattern.compile("(.*)( mother)(.*)", Pattern.CASE_INSENSITIVE);
        responses.put(new CustomPattern(pattern, 3), new ArrayList<>(Arrays.asList(
                "Tell me more about your mother.",
                "What was your relationship with your mother like?",
                "How do you feel about your mother?",
                "How does this relate to your feelings today?",
                "Good family relations are important."
        )));
        pattern = Pattern.compile("(.*)( father)(.*)", Pattern.CASE_INSENSITIVE);
        responses.put(new CustomPattern(pattern, 3), new ArrayList<>(Arrays.asList(
                "Tell me more about your father.",
                "How did your father make you feel?",
                "How do you feel about your father?",
                "Does your relationship with your father relate to your feelings today?",
                "Do you have trouble showing affection with your family?"
        )));
        pattern = Pattern.compile("(.*)( child)(.*)", Pattern.CASE_INSENSITIVE);
        responses.put(new CustomPattern(pattern, 3), new ArrayList<>(Arrays.asList(
                "Did you have close friends as a child?",
                "What is your favorite childhood memory?",
                "Do you remember any dreams or nightmares from childhood?",
                "Did the other children sometimes tease you?",
                "How do you think your childhood experiences relate to your feelings today?"
        )));
        pattern = Pattern.compile("(.*)\\?", Pattern.CASE_INSENSITIVE);
        responses.put(new CustomPattern(pattern, 1), new ArrayList<>(Arrays.asList(
                "Why do you ask that?",
                "Please consider whether you can answer your own question.",
                "Perhaps the answer lies within yourself?",
                "Why don't you tell me?"
        )));
        pattern = Pattern.compile("(quit)", Pattern.CASE_INSENSITIVE);
        responses.put(new CustomPattern(pattern, 1), new ArrayList<>(Arrays.asList(
                "Thank you for talking with me.",
                "Good-bye.",
                "Thank you, that will be $150.  Have a good day!"
        )));
        pattern = Pattern.compile("(.*)", Pattern.CASE_INSENSITIVE);
        responses.put(new CustomPattern(pattern, 1), new ArrayList<>(Arrays.asList(
                "Please tell me more.",
                "Let's change focus a bit... Tell me about your family.",
                "Can you elaborate on that?",
                "Why do you say that (insert)?",
                "I see.",
                "Very interesting.",
                "(insert).",
                "I see.  And what does that tell you?",
                "How does that make you feel?",
                "How do you feel when you say that?"
        )));
        return responses;
    }

    public String getCorrectPronouns(String expression) {
        expression = dataProcessing(expression);
        Map<String, String> replaceable = new HashMap<>();
        Map<String, String> grammarInversion = Stream.of(new String[][]
                {{"am",  "are"},
                {"was", "were"},
                {"i", "you"},
                {"i'd", "you would"},
                {"i've", "you have"},
                {"i'll", "you will"},
                {"my", "your"},
                {"are", "am"},
                {"you've", "I have"},
                {"you'll", "I will"},
                {"your", "my"},
                {"yours", "mine"},
                {"you", "me"},
                {"me", "you"},
                {"yourself", "myself"},
                {"myself", "yourself"}})
                .collect(Collectors.toMap(data -> data[0], data -> data[1]));
        String[] partOfSentence = expression.split(" ");
        int counter = 0;
        for (String s : partOfSentence) {
            if (!(grammarInversion.get(s.toLowerCase()) == null)) {
                String temp = "0000" + ++counter;
                expression = expression.replaceFirst(s, temp);
                replaceable.put(temp, grammarInversion.get(s.toLowerCase()));
            }
        }
        for (String k : replaceable.keySet()) {
            expression = expression.replace(k, replaceable.get(k));
        }
        return expression;
    }

    private String dataProcessing(String message) {
        List<String> ch = new ArrayList<>(Arrays.asList("!", ".", "?"));
        for (String c : ch) {
            message = message.replace(c, "");
        }
        return message.trim();
    }
}
