package com.example.GetAPI.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {

    private long user_id;
    private String username;

    private int post_count;
}
