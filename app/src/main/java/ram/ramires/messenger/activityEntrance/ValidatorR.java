package ram.ramires.messenger.activityEntrance;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.ObservableField;

import java.util.concurrent.TimeUnit;

import io.reactivex.subjects.PublishSubject;
import io.reactivex.subjects.Subject;
import ram.ramires.messenger.BR;

import static ram.ramires.messenger.activityEntrance.ActivityEntrance.logs;

public class ValidatorR extends BaseObservable {
    public ObservableField<Boolean> cliCkable=new ObservableField<>();
    private Subject<String> subjectLogin;
    private Subject<String> subjectMail;
    private Subject<String> subjectPassword;
    private Subject<String> subjectConfirm;
    @Bindable
    public Boolean loginTrue=new Boolean(false);
    @Bindable
    public Boolean mailTrue=new Boolean(false);
    @Bindable
    public Boolean passwordTrue=new Boolean(false);
    @Bindable
    public Boolean confirmTrue=new Boolean(false);
    private String passwordText="";
    private String confirmText="";
    private String mailText="";

    public ValidatorR(){
        subjectLogin = PublishSubject.create();
        subjectMail = PublishSubject.create();
        subjectPassword = PublishSubject.create();
        subjectConfirm = PublishSubject.create();
        subscribe();

    }

    //editText watchers--------------------------------
    public void loginChanged(CharSequence s, int start, int before, int count) {
        subjectLogin.onNext(String.valueOf(s));
    }
    public void mailChanged(CharSequence s, int start, int before, int count){
        subjectMail.onNext(String.valueOf(s));
    }
    public void passwordChanged(CharSequence s, int start, int before, int count){
        subjectPassword.onNext(String.valueOf(s));
    }
    public void confirmChanged(CharSequence s, int start, int before, int count){
        subjectConfirm.onNext(String.valueOf(s));
    }

    public void putServerData(){

    }

    //subscribers------------------------------------------
    private void subscribe(){
        subscribeLogin();
        subscribeMail();
        subscribePassword();
        subscribeConfirm();
    }
    private void subscribeLogin(){
        subjectLogin.sample(1000, TimeUnit.MILLISECONDS)
                .subscribe((String s)->{
                        logs.showLog(s);
                        if (s.equalsIgnoreCase("man")){ //есть ли такой уже?
                            setLoginTrue(true);
                        } else {
                            setLoginTrue(false);
                        }
                    cheakMail();
                    cheackClickable();

                });
    }
    private void subscribeMail(){
        subjectMail.sample(1000, TimeUnit.MICROSECONDS)
                .subscribe((String s)-> {
                    mailText=s;
                    //есть ли такой уже?
                    cheakMail();
                    cheackClickable();
                });
    }
    private void subscribePassword(){
        subjectPassword.sample(1000, TimeUnit.MICROSECONDS)
                .subscribe((String s)-> {
                    if (cheakPassword(s)){    //не менее 4х символов И прочие условия
                        setPasswordTrue(true);
                        passwordText=s;
                    } else {
                        setPasswordTrue(false);  //отчистить confirm
                    }
                    cheakConfirm();
                    cheackClickable();
                });
    }
    private void subscribeConfirm(){
        subjectConfirm.sample(1000, TimeUnit.MICROSECONDS)
                .subscribe((String s)-> {
                    confirmText=s;  //если password валидный и confirm=password
                    cheakConfirm();
                    cheackClickable();
                });
    }

    //cheakers------------------------------------
    private void cheakMail(){
        if  (loginTrue && mailText.equalsIgnoreCase("manable")){
            setMailTrue(true);
        } else {
            setMailTrue(false);
        }
    }
    private boolean cheakPassword(String password){
        boolean hasUppercase=!password.equals(password.toLowerCase());
        boolean hasLowercase = !password.equals(password.toUpperCase());
        boolean length = password.length()>=4;

        boolean hasSpecial;
        String numRegex   = ".*[0-9].*";
        String alphaRegex = ".*[A-Z].*";
        String betaRegex = ".*[a-z].*";
        String nonRegex= ".*[!@#$%^&*].*";

        if (password.matches(numRegex) && password.matches(alphaRegex) && password.matches(betaRegex)
                && !password.matches(nonRegex)) {
            hasSpecial=true;
        } else hasSpecial=false;

        if (hasUppercase && hasLowercase && hasSpecial && length){
            return true;
        }else {
            System.out.println("Пароль должен быть не менее 4 символов, состоять из букв латинского алфавита. " +
                    "Содержать хотя бы одну заглавную и одну строчную буквы и хотя бы одну цифру");
        return false;
        }
    }

    private void cheakConfirm(){
        if (!passwordTrue || !confirmText.equals(passwordText)){
            setConfirmTrue(false);
        } else if (passwordTrue && confirmText.equals(passwordText)){
            setConfirmTrue(true);
        }

    }
    private void cheackClickable(){
        if (loginTrue && mailTrue && passwordTrue && confirmTrue){
            cliCkable.set(true);
        }else cliCkable.set(false);
    }

    //seters---------------------------------------

    public void setLoginTrue(Boolean b){
        this.loginTrue=b;
        notifyPropertyChanged(BR.loginTrue);
    }
    public void setMailTrue(Boolean b){
        this.mailTrue=b;
        notifyPropertyChanged(BR.mailTrue);

    }
    public void setPasswordTrue(Boolean b){
        this.passwordTrue=b;
        notifyPropertyChanged(BR.passwordTrue);

    }
    public void setConfirmTrue(Boolean b){
        this.confirmTrue=b;
        notifyPropertyChanged(BR.confirmTrue);

    }
    //------------------------------------------
    public void clear(){
        setLoginTrue(false);
        setMailTrue(false);
        setPasswordTrue(false);
        setConfirmTrue(false);
        passwordText="";
        confirmText="";
        mailText="";

    }
}
