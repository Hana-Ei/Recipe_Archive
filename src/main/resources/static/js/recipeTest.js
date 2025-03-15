document.addEventListener('DOMContentLoaded', function() {
  const alarmIcon = document.getElementById('alarm');
  const notificationList = document.getElementById('notification-list');

  // 알림 아이콘 클릭 시 목록 토글
  alarmIcon.addEventListener('click', function(event) {
    event.preventDefault();
    event.stopPropagation();
    notificationList.style.display = (notificationList.style.display === 'block') ? 'none' : 'block';
  });

  // 알림 목록 외부를 클릭하면 목록을 숨김
  document.addEventListener('click', function(event) {
    if (!alarmIcon.contains(event.target) && !notificationList.contains(event.target)) {
      notificationList.style.display = 'none';
    }
  });
});
