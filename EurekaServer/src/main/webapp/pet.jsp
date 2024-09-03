<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <title>PetAdoption - Pet Adoption Website Template</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link href="https://fonts.googleapis.com/css2?family=Nunito+Sans&family=Nunito:wght@600;700;800&display=swap" rel="stylesheet"> 

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

    <!-- Flaticon Font -->
    <link href="lib/flaticon/font/flaticon.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" rel="stylesheet" />

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
</head>

<body>
    <!-- Topbar Start -->
    <div class="container-fluid">
       
        <div class="row py-3 px-lg-5">
            <div class="col-lg-4">
                <a href="" class="navbar-brand d-flex align-items-center">
                    <img src="img/logo.png" alt="Logo" width="50px" height="50px" class="mr-2">
                    <h1 class="m-0 display-5 text-capitalize"><span class="text-primary">Pet</span>Adoption</h1>
                </a>
            </div>
            <div class="col-lg-8 text-center text-lg-right">
                <div class="d-inline-flex align-items-center">
                    <div class="d-inline-flex flex-column text-center pr-3 border-right">
                        <h6>Opening Hours</h6>
                        <p class="m-0">8.00AM - 9.00PM</p>
                    </div>
                    <div class="d-inline-flex flex-column text-center px-3 border-right">
                        <h6>Email Us</h6>
                        <p class="m-0">shaikrasool0109@gmail.com</p>
                    </div>
                    <div class="d-inline-flex flex-column text-center pl-3">
                        <h6>Call Us</h6>
                        <p class="m-0">+91-8919211906</p>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- Topbar End -->


    <!-- Navbar Start -->
    <div class="container-fluid p-0">
        <nav class="navbar navbar-expand-lg bg-dark navbar-dark py-3 py-lg-0 px-lg-5">
            <a href="" class="navbar-brand d-block d-lg-none">
                <h1 class="m-0 display-5 text-capitalize font-italic text-white"><span class="text-primary">Safety</span>First</h1>
            </a>
            <button type="button" class="navbar-toggler" data-toggle="collapse" data-target="#navbarCollapse">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse justify-content-between px-3" id="navbarCollapse">
                <div class="navbar-nav mr-auto py-0">
                    <a href="index" class="nav-item nav-link ">Home</a>
                    <a href="about" class="nav-item nav-link">About</a>
                    <a href="pet" class="nav-item nav-link active">Pets Available</a>
                    <a href="service" class="nav-item nav-link">Service</a>
<!--                     <a href="price" class="nav-item nav-link">Price</a> -->
                    <a href="booking" class="nav-item nav-link ">Booking</a>
                    <a href="contact" class="nav-item nav-link">Contact</a>
                    <a href="login" class="nav-item nav-link">LogOut</a>
                
                </div>
            </div>
        </nav>
    </div>
    <!-- Navbar End -->

    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
            display: flex;
            flex-wrap: wrap;
            justify-content: center;
        }
    
        .card {
            background-color: #ffffff;
            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.1);
            border-radius: 8px;
            margin: 10px;
            overflow: hidden;
            width: calc(25% - 20px); /* Four cards per row */
            max-width: 220px; /* Maximum card width */
        }
    
        .card img {
            width: 100%;
            display: block;
            border-top-left-radius: 8px;
            border-top-right-radius: 8px;
        }
    
        .card-text {
            padding: 10px;
        }
    </style>
   <div class="container">
    <h1>Pet for Adoption</h1>
    <form id="pet-form">
        <label for="pet-type">Type:</label>
        <select id="pet-type" name="pet-type" required>
            <option value="" disabled selected>Select a Pet Type</option>
            <option value="dog">Dog</option>
            <option value="cat">Cat</option>
            <option value="others">Others</option>
            <!-- Add more pet types as needed -->
        </select>
        <div class="image-container" id="image-container-dog">
            <div class="container-fluid bg-light pt-5">
                <div class="container py-5">
                    <div class="row pb-3">
                        <div class="col-md-6 col-lg-4 mb-4">
                            <div class="d-flex flex-column text-center bg-white mb-2 p-3 p-sm-5">
                                <h3 class="flaticon-house display-3 font-weight-normal text-secondary mb-3"></h3>
                                <img src="img/dog-1.webp" alt="alternative_text">
                                <div class="card-footer border-0 p-0">
                                    <a href="viewpetdetails" class="btn btn-secondary btn-block p-3" style="border-radius: 0;">Adopt Now</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-4 mb-4">
                            <div class="d-flex flex-column text-center bg-white mb-2 p-3 p-sm-5">
                                <h3 class="flaticon-food display-3 font-weight-normal text-secondary mb-3"></h3>
                                <img src="img/dog-2.jpg" alt="alternative_text">
                                <div class="card-footer border-0 p-0">
                                    <a href="" class="btn btn-secondary btn-block p-3" style="border-radius: 0;">Adopt Now</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-4 mb-4">
                            <div class="d-flex flex-column text-center bg-white mb-2 p-3 p-sm-5">
                                <h3 class="flaticon-grooming display-3 font-weight-normal text-secondary mb-3"></h3>
                                <img src="img/dog-3.jpg" alt="alternative_text">
                                <div class="card-footer border-0 p-0">
                                    <a href="" class="btn btn-secondary btn-block p-3" style="border-radius: 0;">Adopt Now</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-4 mb-4">
                            <div class="d-flex flex-column text-center bg-white mb-2 p-3 p-sm-5">
                                <h3 class="flaticon-grooming display-3 font-weight-normal text-secondary mb-3"></h3>
                                <img src="img/dog-4.jpg" alt="alternative_text">
                                <div class="card-footer border-0 p-0">
                                    <a href="" class="btn btn-secondary btn-block p-3" style="border-radius: 0;">Adopt Now</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-4 mb-4">
                            <div class="d-flex flex-column text-center bg-white mb-2 p-3 p-sm-5">
                                <h3 class="flaticon-grooming display-3 font-weight-normal text-secondary mb-3"></h3>
                                <img src="img/dog-5.jpg" alt="alternative_text">
                                <div class="card-footer border-0 p-0">
                                    <a href="" class="btn btn-secondary btn-block p-3" style="border-radius: 0;">Adopt Now</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-4 mb-4">
                            <div class="d-flex flex-column text-center bg-white mb-2 p-3 p-sm-5">
                                <h3 class="flaticon-grooming display-3 font-weight-normal text-secondary mb-3"></h3>
                                <img src="img/dog-6.jpg" alt="alternative_text">
                                <div class="card-footer border-0 p-0">
                                    <a href="" class="btn btn-secondary btn-block p-3" style="border-radius: 0;">Adopt Now</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Add more dog images as needed -->
        </div>
        <div class="image-container" id="image-container-cat">
            <div class="container-fluid bg-light pt-5">
                <div class="container py-5">
                    <div class="row pb-3">
                        <div class="col-md-6 col-lg-4 mb-4">
                            <div class="d-flex flex-column text-center bg-white mb-2 p-3 p-sm-5">
                                <h3 class="flaticon-house display-3 font-weight-normal text-secondary mb-3"></h3>
                                <img src="img/cat-1.png" alt="alternative_text">
                                <div class="card-footer border-0 p-0">
                                    <a href="" class="btn btn-secondary btn-block p-3" style="border-radius: 0;">Adopt Now</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-4 mb-4">
                            <div class="d-flex flex-column text-center bg-white mb-2 p-3 p-sm-5">
                                <h3 class="flaticon-food display-3 font-weight-normal text-secondary mb-3"></h3>
                                <img src="img/cat-2.jpg" alt="alternative_text">
                                <div class="card-footer border-0 p-0">
                                    <a href="" class="btn btn-secondary btn-block p-3" style="border-radius: 0;">Adopt Now</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-4 mb-4">
                            <div class="d-flex flex-column text-center bg-white mb-2 p-3 p-sm-5">
                                <h3 class="flaticon-grooming display-3 font-weight-normal text-secondary mb-3"></h3>
                                <img src="img/cat-3.jpg" alt="alternative_text">
                                <div class="card-footer border-0 p-0">
                                    <a href="" class="btn btn-secondary btn-block p-3" style="border-radius: 0;">Adopt Now</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-4 mb-4">
                            <div class="d-flex flex-column text-center bg-white mb-2 p-3 p-sm-5">
                                <h3 class="flaticon-house display-3 font-weight-normal text-secondary mb-3"></h3>
                                <img src="img/cat-4.jpg" alt="alternative_text">
                                <div class="card-footer border-0 p-0">
                                    <a href="" class="btn btn-secondary btn-block p-3" style="border-radius: 0;">Adopt Now</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-4 mb-4">
                            <div class="d-flex flex-column text-center bg-white mb-2 p-3 p-sm-5">
                                <h3 class="flaticon-house display-3 font-weight-normal text-secondary mb-3"></h3>
                                <img src="img/cat-5.jpeg" alt="alternative_text">
                                <div class="card-footer border-0 p-0">
                                    <a href="" class="btn btn-secondary btn-block p-3" style="border-radius: 0;">Adopt Now</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-4 mb-4">
                            <div class="d-flex flex-column text-center bg-white mb-2 p-3 p-sm-5">
                                <h3 class="flaticon-house display-3 font-weight-normal text-secondary mb-3"></h3>
                                <img src="img/cat-6.jpg" alt="alternative_text">
                                <div class="card-footer border-0 p-0">
                                    <a href="" class="btn btn-secondary btn-block p-3" style="border-radius: 0;">Adopt Now</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Add more cat images as needed -->
        </div>
        <div class="image-container" id="image-container-others">
            <div class="container-fluid bg-light pt-5">
                <div class="container py-5">
                    <div class="row pb-3">
                        <div class="col-md-6 col-lg-4 mb-4">
                            <div class="d-flex flex-column text-center bg-white mb-2 p-3 p-sm-5">
                                <h3 class="flaticon-house display-3 font-weight-normal text-secondary mb-3"></h3>
                                <img src="img/other-1.jpg" alt="alternative_text">
                                <div class="card-footer border-0 p-0">
                                    <a href="" class="btn btn-secondary btn-block p-3" style="border-radius: 0;">Adopt Now</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-4 mb-4">
                            <div class="d-flex flex-column text-center bg-white mb-2 p-3 p-sm-5">
                                <h3 class="flaticon-food display-3 font-weight-normal text-secondary mb-3"></h3>
                                <img src="img/other-2.jpg" alt="alternative_text">
                                <div class="card-footer border-0 p-0">
                                    <a href="" class="btn btn-secondary btn-block p-3" style="border-radius: 0;">Adopt Now</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-4 mb-4">
                            <div class="d-flex flex-column text-center bg-white mb-2 p-3 p-sm-5">
                                <h3 class="flaticon-grooming display-3 font-weight-normal text-secondary mb-3"></h3>
                                <img src="img/other-3.jpg" alt="alternative_text">
                                <div class="card-footer border-0 p-0">
                                    <a href="" class="btn btn-secondary btn-block p-3" style="border-radius: 0;">Adopt Now</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-4 mb-4">
                            <div class="d-flex flex-column text-center bg-white mb-2 p-3 p-sm-5">
                                <h3 class="flaticon-grooming display-3 font-weight-normal text-secondary mb-3"></h3>
                                <img src="img/other-4.jpg" alt="alternative_text">
                                <div class="card-footer border-0 p-0">
                                    <a href="" class="btn btn-secondary btn-block p-3" style="border-radius: 0;">Adopt Now</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-4 mb-4">
                            <div class="d-flex flex-column text-center bg-white mb-2 p-3 p-sm-5">
                                <h3 class="flaticon-grooming display-3 font-weight-normal text-secondary mb-3"></h3>
                                <img src="img/other-5.jpeg" alt="alternative_text">
                                <div class="card-footer border-0 p-0">
                                    <a href="" class="btn btn-secondary btn-block p-3" style="border-radius: 0;">Adopt Now</a>
                                </div>
                            </div>
                        </div>
                        <div class="col-md-6 col-lg-4 mb-4">
                            <div class="d-flex flex-column text-center bg-white mb-2 p-3 p-sm-5">
                                <h3 class="flaticon-grooming display-3 font-weight-normal text-secondary mb-3"></h3>
                                <img src="img/other-6.jpeg" alt="alternative_text">
                                <div class="card-footer border-0 p-0">
                                    <a href="" class="btn btn-secondary btn-block p-3" style="border-radius: 0;">Adopt Now</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <!-- Add more other images as needed -->
        </div>
        <!-- Add more image containers for other pet types as needed -->
    </form>
</div>
<script>
    const petTypeSelect = document.getElementById("pet-type");
    const dogContainer = document.getElementById("image-container-dog");
    const catContainer = document.getElementById("image-container-cat");
    const othersContainer = document.getElementById("image-container-others");

    petTypeSelect.addEventListener("change", function () {
        const selectedPetType = petTypeSelect.value;
        dogContainer.style.display = "none";
        catContainer.style.display = "none";
        othersContainer.style.display = "none";

        if (selectedPetType === "dog") {
            dogContainer.style.display = "block";
        } else if (selectedPetType === "cat") {
            catContainer.style.display = "block";
        } else if (selectedPetType === "others") {
            othersContainer.style.display = "block";
        }
    });
</script>
    
    <!-- Back to Top -->
    <a href="#" class="btn btn-lg btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>
    <script src="lib/tempusdominus/js/moment.min.js"></script>
    <script src="lib/tempusdominus/js/moment-timezone.min.js"></script>
    <script src="lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

    <!-- Contact Javascript File -->
    <script src="mail/jqBootstrapValidation.min.js"></script>
    <script src="mail/contact.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
</body>

</html>