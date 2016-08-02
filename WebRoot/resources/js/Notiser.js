/**
 * Created by richard on 16-4-28.
 */
(function(global, $) {

    if(!Array.indexOf){
        Array.prototype.indexOf = function(obj)
        {
            for(var i=0; i<this.length; i++)
            {
                if(this[i]==obj)
                {
                    return i;
                }
            }
            return -1;
        }
    }
    var Notiser = function(text) {
        var result = new Notiser.init(text);
        return result;
    };

    // private variables
    var supportedStyles = ['basic', 'warning', 'success'];
    var basicAge = 3000;

    Notiser.prototype = {

        validate : function() {
            // if user sets not supported style, setting style to basic
            if(supportedStyles.indexOf(this.style) === -1) {
                this.style = supportedStyles[0];
            }
        },

        // Setting style
        setStyle : function(style) {
            this.style = style;
            this.validate();
            return this;
        },

        // Setting text
        setText : function(text) {
            this.text = text || '';
            return this;
        },

        // Setting time how long notify is showing
        setAge : function(age) {
            this.age = age > 0 ? age : basicAge;
            return this;
        },

        show : function(selector) {
            var self = this;
            var notiserElement = $(document.createElement('div'))
                .addClass('notiser ' + this.style).append(this.text);
            // adding created div to first in notify list
            notiserElement.prependTo($(selector)).hide().slideDown();

            notiserElement.one('click', function() {
                self.fadeOutAndRemoveElement($(this));
            });

            this.clear(notiserElement)

            return this;
        },

        // clearing notify after timeout
        clear : function(element) {
            setTimeout(this.fadeOutAndRemoveElement, this.age, element);
        },

        // fading out element and removing element from dom
        fadeOutAndRemoveElement : function(element) {
            element.fadeOut(function() {
                this.remove();
            });
        }

    };

    Notiser.init = function(text) {
        this.text = text || '';
        this.style = 'basic';
        this.age = basicAge;
        this.validate();
    };

    Notiser.init.prototype = Notiser.prototype;

    global.notiser = global.$N = Notiser;

})(window, jQuery);