// solving the active menu problem
	switch (test) {

	case 'About Us':
		$('#about').addClass('active');
		break;
	case 'Contact Us':
		$('#contact').addClass('active');
		break;
	case 'All Products':
    		$('#listProducts').addClass('active');
    		break;
    case 'Home':
        	$('#home').addClass('active');
            break;
	default:
            $('#listProducts').addClass('active');
            $('#a_'+ test ).addClass('active');
    		break;
    }