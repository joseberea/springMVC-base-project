package exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.SimpleMappingExceptionResolver;

public class SimpleExceptionHandler extends SimpleMappingExceptionResolver {
	//
	// Para customizar las redirecciones a las paginas de error hay que sobreescribir doResolveException 
	//
	
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		System.out.println(ex.getMessage());
		System.out.println(ex);
		logger.debug(ex.getMessage(), ex);
		return super.doResolveException(request, response, handler, ex);
	}
}
