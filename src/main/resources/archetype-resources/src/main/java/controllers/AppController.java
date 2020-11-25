package ${package}.controllers;

import ${package}.generated.api.AppApi;
import ${package}.generated.dto.AppStatusDto;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "app")
@RestController
public class AppController implements AppApi {

    @Value("${app.version}")
    private final String appVersion = "1.0.0";

    @Override
    public ResponseEntity<AppStatusDto> getStatus() {
        AppStatusDto dto = new AppStatusDto();
        dto.setAppVersion(appVersion);
        return ResponseEntity.ok(dto);
    }

}
