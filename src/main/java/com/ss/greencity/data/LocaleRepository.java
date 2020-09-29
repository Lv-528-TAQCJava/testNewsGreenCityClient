package com.ss.greencity.data;

import java.util.HashMap;

public class LocaleRepository {
    public static HashMap<LocaleTexts, String> getEngLables() {
        HashMap<LocaleTexts, String> result = new HashMap<LocaleTexts, String>();
        result.put(LocaleTexts.ECO_NEWS, " Eco news ");
        result.put(LocaleTexts.ECO_ADVICE, " Tips & Tricks ");
        result.put(LocaleTexts.ECO_MAP, " Places ");
        result.put(LocaleTexts.ABOUT_US, " About us ");
        result.put(LocaleTexts.MY_PROFILE, " My habits ");
        result.put(LocaleTexts.SIGN_IN, " Sign in ");
        result.put(LocaleTexts.SIGN_UP, "Sign up ");

        result.put(LocaleTexts.MAIN_HEADER, "Eco news");
        result.put(LocaleTexts.FILTER_BY, "Filter by");
        result.put(LocaleTexts.ADS, " Ads ");
        result.put(LocaleTexts.EVENTS, " Events ");
        result.put(LocaleTexts.NEWS, " News ");
        result.put(LocaleTexts.EDUCATION, " Education ");
        result.put(LocaleTexts.INITIATIVES, " Initiatives ");
        result.put(LocaleTexts.LIFEHACKS, " Lifehacks ");

        result.put(LocaleTexts.FOLLOW_US, "Follow us");

        return result;
    }

    public static HashMap<LocaleTexts, String> getUaLabels() {
        HashMap<LocaleTexts, String> result = new HashMap<LocaleTexts, String>();
        result.put(LocaleTexts.ECO_NEWS, " Еко новини ");
        result.put(LocaleTexts.ECO_ADVICE, " Поради ");
        result.put(LocaleTexts.ECO_MAP, " Карта ");
        result.put(LocaleTexts.ABOUT_US, " Про нас ");
        result.put(LocaleTexts.MY_PROFILE, " Мій кабінет ");
        result.put(LocaleTexts.SIGN_IN, " Увійти ");
        result.put(LocaleTexts.SIGN_UP, "Зареєструватись ");

        result.put(LocaleTexts.MAIN_HEADER, "Еко новини");
        result.put(LocaleTexts.FILTER_BY, "Фільтрувати за");
        result.put(LocaleTexts.ADS, " Оголошення ");
        result.put(LocaleTexts.EVENTS, " Події ");
        result.put(LocaleTexts.NEWS, " Новини ");
        result.put(LocaleTexts.EDUCATION, " Навчання ");
        result.put(LocaleTexts.INITIATIVES, " Ініціативи ");
        result.put(LocaleTexts.LIFEHACKS, " Лайфхаки ");

        result.put(LocaleTexts.FOLLOW_US, "Приєднуйтесь до нас");

        return result;
    }

    public static HashMap<LocaleTexts, String> getRuLabels() {
        HashMap<LocaleTexts, String> result = new HashMap<LocaleTexts, String>();
        result.put(LocaleTexts.ECO_NEWS, " Эко новости ");
        result.put(LocaleTexts.ECO_ADVICE, " Эко советы ");
        result.put(LocaleTexts.ECO_MAP, " Карта ");
        result.put(LocaleTexts.ABOUT_US, " О нас ");
        result.put(LocaleTexts.MY_PROFILE, " Мой кабинет ");
        result.put(LocaleTexts.SIGN_IN, " Войти ");
        result.put(LocaleTexts.SIGN_UP, "Зарегистрироваться ");

        result.put(LocaleTexts.MAIN_HEADER, " Эко новости ");
        result.put(LocaleTexts.FILTER_BY, "Фильтровать по");
        result.put(LocaleTexts.ADS, " Объявления ");
        result.put(LocaleTexts.EVENTS, " События ");
        result.put(LocaleTexts.NEWS, " Новости ");
        result.put(LocaleTexts.EDUCATION, " Обучение ");
        result.put(LocaleTexts.INITIATIVES, " Инициативы ");
        result.put(LocaleTexts.LIFEHACKS, " Лайфхаки ");

        result.put(LocaleTexts.FOLLOW_US, "Присоединяйтесь к нам");

        return result;
    }

    public static HashMap<LocaleTexts, String> getDefaultLabels() {
        return getUaLabels();
    }
}
