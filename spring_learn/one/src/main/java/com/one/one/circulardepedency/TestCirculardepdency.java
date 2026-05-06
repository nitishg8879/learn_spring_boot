package com.one.one.circulardepedency;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

@Service
public class TestCirculardepdency {

    @Autowired()
    @Lazy
    TestCirculardepdency2 testCirculardepdency2;
}

@Service
class TestCirculardepdency2 {

    @Autowired
    TestCirculardepdency testCirculardepdency;
}
