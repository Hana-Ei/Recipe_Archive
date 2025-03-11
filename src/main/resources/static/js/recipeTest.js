document.addEventListener('DOMContentLoaded', function() {
  const alarmIcon = document.getElementById('alarm'); // 알림 아이콘
  const notificationList = document.getElementById('notification-list'); // 알림 목록

  // 알림 아이콘 클릭 시 알림 목록 토글
  alarmIcon.addEventListener('click', function(event) {
    event.preventDefault(); // 링크의 기본 동작 방지
    event.stopPropagation(); // 이벤트 버블링 방지

    if (notificationList.style.display === 'block') {
      notificationList.style.display = 'none';
    } else {
      notificationList.style.display = 'block';
    }
  });

  // 알림 목록 외부를 클릭하면 목록을 숨김
  document.addEventListener('click', function(event) {
    if (!alarmIcon.contains(event.target) && !notificationList.contains(event.target)) {
      notificationList.style.display = 'none';
    }
  });
});