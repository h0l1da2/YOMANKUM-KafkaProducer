package yomankum.kafka.producer.yomankum.service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import yomankum.kafka.producer.yomankum.api.dto.AccountBookInputNotice;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoticeService {

    private final KafkaTemplate<String, Object> kafkaTemplate;

    public void sendAccountBookInputNotice(AccountBookInputNotice notice) {
        // {이벤트주체}_{식별자}_{식별값}
        // account_id_{id}
        kafkaTemplate.send("accountBook_input_love", notice);
        log.info("AccountBook 쓰기 시작 알림 - id : {}", notice.id());
    }

//    public void sendUpdateNotice(UpdateNotificationDto updateNotification) {
//        kafkaTemplate.send("업데이트알림", updateNotification);
//    }
//
//    public void sendDeleteNotice(DeleteNotificationDto deleteNotification) {
//        kafkaTemplate.send("삭제알림", deleteNotification);
//    }
}
