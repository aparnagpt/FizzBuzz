$(() => {
    $('#add').click(addNumber);
    $('#submit').click(doFizzBuzz);
    $('#reset').click(reset);
    $('#main').on('click', '.remove', removeNumber);
    $('#main').on('input', '.number-input', validateInput);
});

const addNumber = () => {
    $('#main').append('<div><button class="remove">&#10060;</button><input type="number" class="number-input"><span class="result"></span></div>');
    enableDisableSubmit();
};

const removeNumber = event => {
    $(event.target).parent().remove()
};

const inputRegex = /^[1-9][0-9]{0,8}$/;

const validateInput = event => {
    const input = $(event.target);
    input.toggleClass('error', !inputRegex.test(input.val()));
    enableDisableSubmit();
};

const enableDisableSubmit = () => {
    const error = $('.number-input.error').length;
    const empty = $('.number-input').filter(function () {
        return $(this).val() == "";
    }).length;
    $('#submit').prop('disabled', error || empty)
};

const doFizzBuzz = () => {
    const numbers = $('.number-input').map(function () {
        return $(this).val();
    }).get().join(",");
    $.get("/api/fizzbuzz?numbers=" + numbers, showResults);
};

const showResults = data => {
    const fizzBuzzedNumbers = data.split(", ");
    console.log(fizzBuzzedNumbers);
    $('.result').each(function (index) {
        $(this).text(fizzBuzzedNumbers[index]);
    });
};

const reset = () => {
    location.reload();
};