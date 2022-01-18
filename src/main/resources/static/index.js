$(document).ready(function(){
  let dateData = getDateTime();
  $("#date-conv").html(dateData[0]);
  $("#first-message").html(dateData[1]);
});

function getDateTime() {
  let display = [];
  const monthNames = ["Jan", "Feb", "Mar", "Apr", "May", "Jun",
    "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
  let date = new Date();
  let shownDate = date.getDate() + " " + monthNames[date.getMonth()];
  let shownDateTime = (parseInt(date.getHours()) < 10 ? ("0" + date.getHours()) : date.getHours()) + ":" + (parseInt(date.getMinutes()) < 10 ? ("0" + date.getMinutes()) : date.getMinutes()) + " | " + shownDate;
  display.push(shownDate);
  display.push(shownDateTime);
  return display;
}

function submitInput() {
  let value = $("#input-value").val();
  if (value === "" || value === null || value === undefined) {
    return;
  }
  $("#focal").remove();
  $("#input-value").val("")
  let dateData = getDateTime();
  placeholder = `
  <!-- Sender Message-->
  <div class="media w-50 mb-3"><img src="avatar.svg" alt="user" width="50" class="rounded-circle">
    <div class="media-body ml-3">
    <div class="bg-light rounded py-2 px-3 mb-2">
      <p class="text-medium mb-0 text-muted">` + value + `</p>
    </div>
    <p class="small text-muted">` + dateData[1] + `</p>
    </div>
  </div>
  <div id="focal"></div>
  `;
  $("#chat-box").append(placeholder);
  $('#chat-box').animate({ scrollTop: $("#chat-box")[0].scrollHeight}, 400, 'linear');
  createLoader();
  let seconds = parseInt(getRandomSleepTime());
  setTimeout(function() {
    $("#loading").remove();
    setTimeout(function() {
      getResponse(value);
    }, 1500);
  }, seconds);
}

function getRandomSleepTime() {
  let randomSec = parseInt(Math.floor(Math.random() * (6000 - 2000) + 2000));
  return randomSec;
}

function createLoader() {
  placeholder = `
  <div id="loading" class="media w-50 ml-auto mb-2">
		<div class="media-body">
      <div class="bg-primary rounded px-5 mb-2 mx-3">
        <p class="text-small mb-0 text-white">
          <div class="lds-ellipsis mx-5"><div></div><div></div><div></div><div></div></div>
        </p>
      </div>
		</div>
	</div>
  `
  $("#chat-box").append(placeholder);
  $('#chat-box').animate({ scrollTop: $("#loading").offset().top}, 500, 'swing');
}

function getResponse(value) {
  var myHeaders = new Headers();
  myHeaders.append("Content-Type", "application/json");

  var raw = JSON.stringify({
    "message": value
  });

  var requestOptions = {
    method: 'POST',
    headers: myHeaders,
    body: raw,
    redirect: 'follow'
  };

  fetch("http://localhost:8080/api/v1/response", requestOptions)
    .then(response => {
      if (response.status !== 200) {
        throw "Something went wrong";
      }
      return response.json();
    })
    .then(result => {
      $("#focal").remove();
      let dateData = getDateTime();
      let placeholder = `
      <!-- Receiver Message-->
      <div class="media w-50 ml-auto mb-3">
        <div class="media-body">
        <div class="bg-primary rounded py-2 px-3 mb-2">
          <p class="text-medium mb-0 text-white">` + result.message + `</p>
        </div>
        <p class="small text-muted">` + dateData[1] + `</p>
        </div>
      </div>
      <div id="focal"></div>
      `;
      $("#chat-box").append(placeholder);
      $('#chat-box').animate({ scrollTop: $("#chat-box")[0].scrollHeight}, 400, 'swing');
    })
    .catch(error => console.log('error', error));
  }