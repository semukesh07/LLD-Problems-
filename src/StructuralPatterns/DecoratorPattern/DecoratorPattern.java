package StructuralPatterns.DecoratorPattern;


// base class
abstract class TextSource {

    abstract String getText(String input);
}


class PlainText extends TextSource{

    @Override
    String getText(String input) {
        return input;
    }
}

class HypenText extends  TextSource{

    @Override
    String getText(String input) {
        return input.concat("added hypen");
    }
}

abstract  class TextDecorator extends  TextSource
{
    TextSource textSource;

    TextDecorator(TextSource textSource)
}

class UpperCaseDecorator extends  TextDecorator {

    TextSource textSource;

    UpperCaseDecorator(TextSource textSource){
        this.textSource = textSource;
    }

    @Override
    String getText(String input) {
        return textSource.getText(input).toUpperCase();
    }
}

class TrimDecorator extends TextDecorator {

    TextSource textSource;
    super();

    @Override
    String getText(String input) {
        return textSource.getText(input).trim();
    }
}

class DecoratorPattern {

    static void main(String[] args){
        System.out.println(new TrimDecorator(new UpperCaseDecorator(new PlainText())).getText("   mukesh  "));
        System.out.println(new UpperCaseDecorator(new HypenText()).getText("Mukesh  "));
    }

}
