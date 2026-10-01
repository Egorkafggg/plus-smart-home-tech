package ru.yandex.practicum.telemetry.collector.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import ru.yandex.practicum.telemetry.collector.dto.hub.HubEvent;
import ru.yandex.practicum.telemetry.collector.dto.sensor.SensorEvent;
import ru.yandex.practicum.telemetry.collector.service.CollectorService;

@RestController
@RequestMapping("/events")
@RequiredArgsConstructor
public class EventController {

    private final CollectorService collectorService;

    @PostMapping("/sensors")
    @ResponseStatus(HttpStatus.OK)
    public void collectSensorEvent(@RequestBody SensorEvent event) {
        collectorService.collectSensorEvent(event);
    }

    @PostMapping("/hubs")
    @ResponseStatus(HttpStatus.OK)
    public void collectHubEvent(@RequestBody HubEvent event) {
        collectorService.collectHubEvent(event);
    }
}