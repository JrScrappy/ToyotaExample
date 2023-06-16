const menuToggle = document.querySelector('.menu-toggle');
    const dropdownMenu = document.querySelector('.dropdown-menu');

    menuToggle.addEventListener('click', () => {
      dropdownMenu.classList.toggle('active');
    });
    window.addEventListener('resize', () => {
      if (window.innerWidth > 768) {
        dropdownMenu.classList.remove('active');
      }
    });

    document.addEventListener('click', (event) => {
      const targetElement = event.target;
      if (!targetElement.closest('.navpanel')) {
        dropdownMenu.classList.remove('active');
      }
    });

    // Блокируем взаимодействие пользователя
function disableInteraction() {
  document.body.style.pointerEvents = "none";
}

// Разблокируем взаимодействие пользователя
function enableInteraction() {
  document.body.style.pointerEvents = "auto";
}

// Запускаем блокировку на 5 секунд при загрузке страницы
window.addEventListener("load", function() {
  disableInteraction();
  setTimeout(enableInteraction, 4000); // 5000 миллисекунд = 5 секунд
});

// Блокируем скролл страницы
function disableScroll() {
  document.body.style.overflow = "hidden";
}

// Разблокируем скролл страницы
function enableScroll() {
  document.body.style.overflow = "auto";
}

// Запускаем блокировку скролла на 5 секунд при загрузке страницы
window.addEventListener("load", function() {
  disableScroll();
  setTimeout(enableScroll, 4000); // 5000 миллисекунд = 5 секунд
});

// Перемещаем пользователя в самое начало страницы
function scrollToTop() {
  window.scrollTo(0, 0);
}

// Запускаем перемещение при перезагрузке страницы
window.addEventListener("beforeunload", scrollToTop);