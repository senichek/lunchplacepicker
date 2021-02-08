package com.olexiy.lunchplacepicker.controllers.like;

import com.olexiy.lunchplacepicker.models.Menu;
import com.olexiy.lunchplacepicker.service.menu.MenuService;
import com.olexiy.lunchplacepicker.utils.exceptions.NotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.List;

@Controller
public abstract class AbstractLikeController {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private MenuService menuService;

    public AbstractLikeController() {
    }

}