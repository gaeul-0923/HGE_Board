(function ($) {
  $.fn.json = function () {
    var result = {};
    if (typeof (this[0]) === "undefined") {
    } else {
      if (this[0].tagName && this[0].tagName.toUpperCase() === "FORM") {

      } else {
        $.alert("FORM tag가 아닙니다.");
        return "";
      }
      var extend = function (i, element) {
        var node = result[element.name];
        if ("undefined" !== typeof node && node !== null) {
          if ($.isArray(node)) {
            node.push(element.value)
          } else {
            result[element.name] = [node, element.value];
          }
        } else {
          result[element.name] = element.value;
        }
      };
      $.each(this.serializeArray(), extend);

      if (result === {}) {
        $.alert("화면에 값이 없습니다.");
        return "";
      }
    }
    return JSON.stringify(result);
  };
})(jQuery);