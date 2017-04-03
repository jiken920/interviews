/*
Write a function that will recursively merge two objects with the following conditions:

1.) If a[field] is an array, and b[field] is defined and is not an array, add b[field] to the array
2.) If a[field] is an array an b[field] exists but is undefined or null, set a[field] to an empty array
3.) If a[filed] is an array and b[field] is an array, set a[field] to b[field]
4.) If a[field] exists and b[field] exists but is undefined, delete a[field]
5.) If b[field] is a non-complex type (number, string, boolean, et cetera), copy to a[field]
*/

var dest = {
	first_name: 'Bob',
	last_name: 'Joness',

	email: 'bob@gmail.com',

	address: {
		line_1: '1234 Main St',
		line_2: 'Apt 413',
		city: 'Los Angeles',
		state: 'CA',
		zip: '90048',
        test: {
            val: 'bar'
        }
	},

	logins: [
		{ date: '10/22/2012', ip: '192.168.0.1' },
		{ date: '10/21/2012', ip: '192.168.0.1' }
	],

	photos: [
		'IMG-1985.jpg',
		'IMG-1987.jpg'
	],

    data: [ 1, 2, 3 ]
}

var src = {
	last_name: 'Jones',
	active: true,

	address: {
		line_1: '2143 South Main St',
		line_2: undefined,
        test: {
            val: 'foo'
        }
	},

	logins: { date: '10/23/2012', ip: '192.168.0.1' },

	photos: undefined,

    data: [ 4, 5, 6 ]
}

function merge(src, dest) {
    if(dest == null || src == null) {
        return;
    }

    for(var prop in src) {
        if(dest.hasOwnProperty(prop)) {
            if(Array.isArray(dest[prop])) {
                if(src.hasOwnProperty(prop)) {
                    if(src[prop] == null) {
                        // If dest[field] is an array an src[field] exists but is undefined or null, set dest[field] to an empty array
                        dest[prop] = [];
                    }
                    else if(Array.isArray(src[prop])) {
                        //If dest[field] is an array and src[field] is an array, set dest[field] to src[field]
                        dest[prop] = src[prop];
                    } else {
                        // If dest[field] is an array, and src[field] is defined and is not an array, add src[field] to the array
                        dest[prop].push(src[prop]);
                    }
                    merge(src[prop], dest[prop]);
                } else {
                    dest[prop] = [];
                }
            } else {
                if(src.hasOwnProperty(prop)) {
                    if(src[prop] == null) {
                        // If dest[field] exists and src[field] exists but is undefined, delete dest[field]
                        delete dest[prop];
                    } else if(typeof src[prop] != "object") {
                        // If src[field] is a non-complex type (number, string, boolean, et cetera), copy to dest[field]
                        dest[prop] = src[prop];
                    } else {
                        merge(src[prop], dest[prop]);
                    }
                }
            }
        } else if(src.hasOwnProperty(prop)) {
            // Copy over any properties that exist in src but not in dest
            dest[prop] = src[prop];
        }
    }
}

merge(src, dest);
var out = JSON.stringify(dest, null, 2);
console.log(out);