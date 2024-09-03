const petTypeSelect = document.getElementById('pet-type');
const petDetailsContainer = document.getElementById('pet-details');

petTypeSelect.addEventListener('change', function() {
    const selectedType = this.value;
    
    // Clear existing pet details
    petDetailsContainer.innerHTML = '';

    if (selectedType) {
        petDetailsContainer.style.display = 'block';

        // Create additional fields based on selected pet type
        if (selectedType === 'dog') {
            createDogFields();
        } else if (selectedType === 'cat') {
            createCatFields();
        }
        // Add more conditions for other pet types
    } else {
        petDetailsContainer.style.display = 'none';
    }
});

function createDogFields() {
    // Create and append dog-specific fields
}

function createCatFields() {
    // Create and append cat-specific fields
}

