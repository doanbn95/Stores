$(document).ready(function () {
    //Load Image
    $("#image_file").change(function (e) {
        loadImage(this)
    });

});

/**
 * The load image url
 * @param input
 */
function loadImage(input) {
    if (input.files && input.files[0]) {
        let reader = new FileReader();
        reader.onload = function (e) {
            $('#image_view').attr('src', e.target.result);
        }
        reader.readAsDataURL(input.files[0]);
    }
}