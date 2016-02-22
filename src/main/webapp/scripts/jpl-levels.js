$(function () { // wait for page to load
    var branchDropdown = $("#branches"),
        levelDropdown = $('<select></select>'), // create a level dropdown
        levels = []; // ordered list of countries
    
    // parse the nested dropdown
    brachDropdown.children().each(function () {
        var group = $(this),
            levelName = group.attr('label'),
            option;
        
        // create an option for the country
        option = $('<option></option>').text(levelName);
        
        // store the associated city options
        option.data('branches', group.children());
        
        // check if the country should be selected
        if( group.find(':selected').length > 0 ) {
            option.prop('selected', true);
        }
        
        // add the country to the dropdown
        levelDropdown.append(option);
    });
    
    // add the country dropdown to the page
    branchDropdown.before(levelDropdown);
    
    // this function updates the city dropdown based on the selected country
    function updateLevels() {
        var level = levelDropdown.find(':selected');
        branchDropdown.empty().append(level.data('branches'));
    }
    
    // call the function to set the initial cities
    updateBranches();
    
    // and add the change handler
    levelDropdown.on('change', updateBranches);
});